package com.leo.crud.vendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String externalId;

    private String name;

    private String keyPix;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[]  imgQrCode;

    @OneToMany(mappedBy = "bank")
    private List<Sale> sales = new ArrayList<>();

    @ManyToMany(mappedBy = "banks")
    private List<User> users = new ArrayList<>();

    public Bank(Long id, String name, String keyPix, byte[] imgQrCode) {
        this.id = id;
        this.name = name;
        this.keyPix = keyPix;
        this.imgQrCode = imgQrCode;
    }

    public Bank() {
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

    public String getKeyPix() {
        return keyPix;
    }

    public void setKeyPix(String keyPix) {
        this.keyPix = keyPix;
    }

    public byte[] getImgQrCode() {
        return imgQrCode;
    }

    public void setImgQrCode(byte[] imgQrCode) {
        this.imgQrCode = imgQrCode;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
