package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
