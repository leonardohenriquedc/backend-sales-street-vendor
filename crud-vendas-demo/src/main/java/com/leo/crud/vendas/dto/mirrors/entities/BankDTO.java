package com.leo.crud.vendas.dto.mirrors.entities;

public record BankDTO(Long id, String externalId, String name, String keyPix, Byte[] imgQrCode) {
}
