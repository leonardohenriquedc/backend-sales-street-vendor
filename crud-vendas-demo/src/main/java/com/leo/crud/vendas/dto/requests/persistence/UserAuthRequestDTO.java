package com.leo.crud.vendas.dto.requests.persistence;

import jakarta.validation.constraints.NotBlank;

public record UserAuthRequestDTO(
        @NotBlank  String email,
        @NotBlank String password
) {
}
