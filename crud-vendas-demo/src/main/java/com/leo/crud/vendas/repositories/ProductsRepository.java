package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByExternalId(String externalId);
}
