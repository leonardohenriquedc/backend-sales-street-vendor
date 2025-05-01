package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.requests.persistence.UserAuthRequestDTO;
import com.leo.crud.vendas.dto.requests.persistence.UserPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.UserPersistenceResponseDTO;
import com.leo.crud.vendas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping( value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserAuthRequestDTO userAuthRequestDTO){

        String token = userService.login(userAuthRequestDTO);

        return ResponseEntity.ok(token);

    }

    @PostMapping(value = "/new")
    public ResponseEntity newUser(@RequestBody @Valid UserPersistenceRequestDTO userPersistenceRequestDTO) throws URISyntaxException {
        String externalID = userService.newUser(userPersistenceRequestDTO);

        URI endereco = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/login").buildAndExpand().toUri();

        return ResponseEntity.created(endereco).build();
    }
}
