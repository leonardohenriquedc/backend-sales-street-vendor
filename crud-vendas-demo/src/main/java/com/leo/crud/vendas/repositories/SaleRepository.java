package com.leo.crud.vendas.repositories;

import com.leo.crud.vendas.entities.Sale;
import com.leo.crud.vendas.projections.SaleReportProjectionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Deprecated
    @Query(nativeQuery = true, value = "select tb_products.name as product, " +
            "SUM(tb_sales.amount) as amount, " +
            "tb_sales.unit_value as unitValue, " +
            "ROUND(SUM(tb_sales.amount) * tb_sales.unit_value, 2) as total " +
            "from tb_products_sales tps " +
            "inner join tb_products on tps.product_id = tb_products.id " +
            "inner join tb_sales on tb_sales.id = tps.sale_id " +
            "where tb_sales.date_sale between :initDate and :finalDate and tb_products.id = :idProduct " +
            "group by tb_products.name, tb_sales.unit_value")
    List<SaleReportProjectionRecord> searchReportSales(
            @Param("initDate") LocalDate initDate,
            @Param("finalDate")LocalDate finalDate,
            @Param("idProduct")Long idProduct
    );
}