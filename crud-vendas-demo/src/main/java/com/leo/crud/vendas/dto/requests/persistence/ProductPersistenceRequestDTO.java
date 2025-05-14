package com.leo.crud.vendas.dto.requests.persistence;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductPersistenceRequestDTO(

        @NotBlank
        String id,

        @NotBlank
        String name,

        @NotNull
        BigDecimal price,

        @NotNull
        Integer amount
) {
}