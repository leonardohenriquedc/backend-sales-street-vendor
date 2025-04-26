package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByExternalId(String externalId);

    UserDetails findByEmail(String email);
}
