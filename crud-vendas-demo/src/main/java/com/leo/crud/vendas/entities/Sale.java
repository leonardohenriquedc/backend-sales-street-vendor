package com.leo.crud.vendas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String externalId;

    private Integer amountProducts;

    private BigDecimal totalPrice;

    private LocalDate dateSale;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    private PaymentMethod paymentMethod;

    @ManyToMany(mappedBy = "sales")
    private List<User> users = new ArrayList<>();

    public Sale(Long id, Integer amountProducts, BigDecimal totalPrice, LocalDate localDate) {
        this.id = id;
        this.amountProducts = amountProducts;
        this.totalPrice = totalPrice;
        this.dateSale = localDate;
    }

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmountProducts() {
        return amountProducts;
    }

    public void setAmountProducts(Integer amountProducts) {
        this.amountProducts = amountProducts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
