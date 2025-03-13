package com.leo.crud.vendas.dto;

import com.leo.crud.vendas.entities.Bank;
import org.springframework.web.multipart.MultipartFile;

public class BankDTO {

    private Long id;

    private String name;

    private String keyPix;

    private MultipartFile imgQrCode;

    public BankDTO(Long id, String name, String keyPix, MultipartFile imgQrCode) {
        this.id = id;
        this.name = name;
        this.keyPix = keyPix;
        this.imgQrCode = imgQrCode;
    }

    public BankDTO(Bank bank){

        id = bank.getId();
        name = bank.getName();
        keyPix = bank.getKeyPix();
    }

    public BankDTO() {
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

    public MultipartFile getImgQrCode() {
        return imgQrCode;
    }

    public void setImgQrCode(MultipartFile imgQrCode) {
        this.imgQrCode = imgQrCode;
    }
}
