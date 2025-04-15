package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String method;

    @OneToOne(mappedBy = "paymentMethod")
    private Sale sale;

    public PaymentMethod(Long id, String method) {
        this.id = id;
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
