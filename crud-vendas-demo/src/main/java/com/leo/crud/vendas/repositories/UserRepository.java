package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
