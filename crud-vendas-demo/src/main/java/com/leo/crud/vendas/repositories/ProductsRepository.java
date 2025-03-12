package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
