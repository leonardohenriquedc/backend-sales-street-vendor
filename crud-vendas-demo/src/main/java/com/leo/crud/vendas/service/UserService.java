package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.UserDTO;
import com.leo.crud.vendas.dto.requests.persistence.UserPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.UserPersistenceResponseDTO;
import com.leo.crud.vendas.entities.User;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
