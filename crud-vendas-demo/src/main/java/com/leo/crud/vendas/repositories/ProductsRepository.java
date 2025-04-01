package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
