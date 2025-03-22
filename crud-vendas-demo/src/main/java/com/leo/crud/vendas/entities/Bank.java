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

    private String name;

    private String keyPix;

    @Lob
    private byte[]  imgQrCode;

    @OneToMany(mappedBy = "bank")
    private List<Sale> sales = new ArrayList<>();

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
}
