package com.leo.crud.vendas.dto.responses.persistence;

import java.math.BigDecimal;

public record ProductPersistenceResponseDTO(String id, String name, BigDecimal unitPrice) {
}
