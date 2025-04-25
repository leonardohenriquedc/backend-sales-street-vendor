package com.leo.crud.vendas.dto.responses.persistence;

public record BankPersistenceResponseDTO(String id, String name, String keyPix, byte[] imgQrCode) {
}