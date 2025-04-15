package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product_amounts")
public class ProductAmount {

    @EmbeddedId
    ProductAmountKey id = new ProductAmountKey();

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;


    private Integer amount;

    private BigDecimal unit_price;

    public ProductAmount(Integer amount, BigDecimal unit_price) {
        this.amount = amount;
        this.unit_price = unit_price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }
}
