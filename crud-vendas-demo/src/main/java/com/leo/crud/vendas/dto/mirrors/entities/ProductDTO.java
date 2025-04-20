package com.leo.crud.vendas.dto.mirrors.entities;

import java.math.BigDecimal;

public record ProductDTO(Long id, String externalId, String name, BigDecimal price) {
}
