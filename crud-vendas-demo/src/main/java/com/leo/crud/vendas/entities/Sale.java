package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidade;

    private Double initValue;

    @ManyToMany
    @JoinTable(name = "tb_products_sales",
    joinColumns = @JoinColumn(name = "products_id"),
    inverseJoinColumns = @JoinColumn(name = "sales_id"))
    private List<Products> products;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Sale(Long id, Long quantidade, Double initValue) {
        this.id = id;
        this.quantidade = quantidade;
        this.initValue = initValue;
    }

    public Sale() {
    }

    public void addProducts (Products products){
        this.products.add(products);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getInitValue() {
        return initValue;
    }

    public void setInitValue(Double initValue) {
        this.initValue = initValue;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
