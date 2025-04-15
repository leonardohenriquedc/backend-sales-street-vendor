package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "tb_amount_products_stock")
public class AmountProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;

    public AmountProductStock(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
