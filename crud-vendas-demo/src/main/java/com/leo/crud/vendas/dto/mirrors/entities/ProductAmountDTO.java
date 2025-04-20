package com.leo.crud.vendas.dto.mirrors.entities;

import java.math.BigDecimal;

public record ProductAmountDTO(UserDTO user, SaleDTO sale, Integer amount, BigDecimal unitPrice) {
}
