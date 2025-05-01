package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.RoleDTO;
import com.leo.crud.vendas.dto.mirrors.entities.UserDTO;
import com.leo.crud.vendas.dto.requests.persistence.UserAuthRequestDTO;
import com.leo.crud.vendas.dto.requests.persistence.UserPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.UserPersistenceResponseDTO;
import com.leo.crud.vendas.entities.Role;
import com.leo.crud.vendas.entities.User;
import com.leo.crud.vendas.exceptions.ResourceAlreadyExists;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    GeneratedHash generatedHash;

    @Autowired
    RoleService roleService;

    public UserPersistenceResponseDTO findByExternalId(String id){
        Optional<User> result = userRepository.findByExternalId(id);

        if(result.isPresent()){
            return new UserPersistenceResponseDTO(
                    result.get().getExternalId(),
                    result.get().getName(),
                    result.get().getEmail(),
                    result.get().getPassword()
            );
        }

        throw new ResourceNotFound("Id of the user not found");
    }

    public UserDTO findBy(Long id){

        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()){

            return new UserDTO(
                    result.get().getId(),
                    result.get().getExternalId(),
                    result.get().getName(),
                    result.get().getEmail(),
                    result.get().getPassword()
            );
        }

        throw new ResourceNotFound("Id of the user not found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username);

    }

    public String login(UserAuthRequestDTO userAuthRequestDTO){
        UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(userAuthRequestDTO.email(), userAuthRequestDTO.password());

        System.out.println("Este e o  authToken: " + authtoken.toString());

        Authentication auth = this.authenticationManager.authenticate(authtoken);

        String token = generatedHash.generationToken((User) auth.getPrincipal());

        System.out.println("Este e o token " + token);

        return token;
    }

    public String newUser(UserPersistenceRequestDTO userPersistenceRequestDTO) {
        if(userRepository.findByEmail(userPersistenceRequestDTO.email()) != null){
            throw new ResourceAlreadyExists("Recurso ja existe");
        }

        String externalId = generatedHash.generatedHash(userPersistenceRequestDTO.email(), userPersistenceRequestDTO.password());

        String passwordEncoder = new BCryptPasswordEncoder().encode(userPersistenceRequestDTO.password());

        RoleDTO roleDTO = roleService.fingByRole("ROLE_SELLER");

        User user = new User(
                null,
                externalId,
                userPersistenceRequestDTO.name(),
                userPersistenceRequestDTO.email(),
                passwordEncoder
        );

        user.getRoles().add(new Role(roleDTO.id(), roleDTO.role()));

        user = userRepository.save(user);

        return user.getExternalId();
    }
}
