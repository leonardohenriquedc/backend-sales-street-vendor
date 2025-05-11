package com.leo.crud.vendas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String externalId;

    private String name;

    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private List<User> users = new ArrayList<>();

    @OneToOne(mappedBy = "product")
    private AmountProductStock amountProductStock;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String externalId, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.externalId = externalId;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public AmountProductStock getAmountProductStock() {
        return amountProductStock;
    }

    public void setAmountProductStock(AmountProductStock amountProductStock) {
        this.amountProductStock = amountProductStock;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
