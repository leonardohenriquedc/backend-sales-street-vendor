package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.ProductAmount;
import com.leo.crud.vendas.entities.ProductAmountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductAmountRepository extends JpaRepository<ProductAmount, ProductAmountKey> {

    Optional<ProductAmount> findBySaleIdAndProductId(Long saleId, Long productId);

    Optional<ProductAmount> findBySaleId(Long id);

    List<ProductAmount> findAllBySaleId(Long id);

    @Query(nativeQuery = true, value = "select pa.* " +
            "from tb_products_amounts pa " +
            "inner join tb_sales " +
            "on tb_sales.id = pa.sale_id " +
            "where tb_sales.external_id= :externalId ;")
    List<ProductAmount> findAllBySaleExternalId(String externalId);
}
