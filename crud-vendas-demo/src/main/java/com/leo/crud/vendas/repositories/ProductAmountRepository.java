package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.ProductAmount;
import com.leo.crud.vendas.entities.ProductAmountKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductAmountRepository extends JpaRepository<ProductAmount, ProductAmountKey> {

    Optional<ProductAmount> findBySaleIdAndProductId(Long saleId, Long productId);

    Optional<ProductAmount> findBySaleId(Long id);
}
