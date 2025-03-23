package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    private Double unitValue;

    private LocalDate dateSale;

    @ManyToMany
    @JoinTable(name = "tb_products_sales",
    inverseJoinColumns = @JoinColumn(name = "product_id"),
    joinColumns = @JoinColumn(name = "sale_id"))
    private List<Products> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Sale(Long id, Integer amount, Double unitValue, LocalDate localDate) {
        this.id = id;
        this.amount = amount;
        this.unitValue = unitValue;
        this.dateSale = localDate;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
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

    public LocalDate getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDate dateSale) {
        this.dateSale = dateSale;
    }
}
