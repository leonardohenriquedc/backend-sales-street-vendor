package com.leo.crud.vendas.dto.responses.persistence;

public record BankPersistenceDTO(String id, String name, String keyPix, byte[] imgQrCode) {
}
