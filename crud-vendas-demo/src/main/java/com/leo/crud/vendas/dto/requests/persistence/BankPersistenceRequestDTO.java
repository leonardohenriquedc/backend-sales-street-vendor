package com.leo.crud.vendas.dto.requests.persistence;

public record BankPersistenceRequestDTO(String name, String keyPix, byte[] imgQrCode) {
}
