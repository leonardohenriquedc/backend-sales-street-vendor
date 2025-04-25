package com.leo.crud.vendas.dto.requests.persistence;

import java.math.BigDecimal;

public record ProductPersistenceRequestDTO(String externalId, String name, BigDecimal price) {
}