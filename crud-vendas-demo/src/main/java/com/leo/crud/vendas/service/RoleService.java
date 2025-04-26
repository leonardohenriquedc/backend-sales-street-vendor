package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.RoleDTO;
import com.leo.crud.vendas.entities.Role;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleDTO fingByRole(String role){
        Optional<Role> result = roleRepository.findByRole(role);

        if(result.isEmpty()) throw new ResourceNotFound("Role não existe");

        return new RoleDTO(
                result.get().getId(),
                result.get().getRole()
        );
    }
}
