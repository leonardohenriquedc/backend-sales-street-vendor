package com.leo.crud.vendas.dto.requests.persistence;

public record BankPersistenceRequest(String name, String keyPix, byte[] imgQrCode) {
}
