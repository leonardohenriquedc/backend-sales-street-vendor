package com.leo.crud.vendas.dto;

import org.springframework.web.multipart.MultipartFile;

public class CreateBankDTO {

    private String name;

    private String keyPix;

    private MultipartFile imageQrCode;

    public CreateBankDTO(String name, String keyPix, MultipartFile imageQrCode) {
        this.name = name;
        this.keyPix = keyPix;
        this.imageQrCode = imageQrCode;
    }

    public CreateBankDTO() {
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

    public MultipartFile getImageQrCode() {
        return imageQrCode;
    }

    public void setImageQrCode(MultipartFile imageQrCode) {
        this.imageQrCode = imageQrCode;
    }
}
