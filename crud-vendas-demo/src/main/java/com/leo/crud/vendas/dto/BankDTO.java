package com.leo.crud.vendas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leo.crud.vendas.entities.Bank;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDTO {

    private Long id;

    private String name;

    private String keyPix;

    private byte[] imgQrCode;

    public BankDTO(Long id, String name, String keyPix, byte[] imgQrCode) {
        this.id = id;
        this.name = name;
        this.keyPix = keyPix;
        this.imgQrCode = imgQrCode;
    }

    public BankDTO(Bank bank){

        id = bank.getId();
        name = bank.getName();
        keyPix = bank.getKeyPix();
        imgQrCode = bank.getImgQrCode();
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

    public byte[] getImgQrCode() {
        return imgQrCode;
    }

    public void setImgQrCode(byte[] imgQrCode) {
        this.imgQrCode = imgQrCode;
    }
}
