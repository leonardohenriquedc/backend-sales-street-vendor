package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
