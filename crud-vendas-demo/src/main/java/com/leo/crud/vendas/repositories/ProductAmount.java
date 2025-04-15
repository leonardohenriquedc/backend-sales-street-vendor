package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.ProductAmountKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAmount extends JpaRepository<ProductAmount, ProductAmountKey> {
}
