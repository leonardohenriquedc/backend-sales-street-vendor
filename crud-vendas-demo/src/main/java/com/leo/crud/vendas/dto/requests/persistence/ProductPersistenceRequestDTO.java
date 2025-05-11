package com.leo.crud.vendas.dto.requests.persistence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductPersistenceRequestDTO(

        String externalId,

        @NotBlank
        String name,

        BigDecimal price
) {
}