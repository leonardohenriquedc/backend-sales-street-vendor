package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByExternalId(String externalId);
}
