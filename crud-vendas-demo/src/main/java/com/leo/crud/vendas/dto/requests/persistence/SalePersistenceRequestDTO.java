package com.leo.crud.vendas.dto.requests.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record SalePersistenceRequestDTO(Date dateSale, String bankId, BigDecimal totalPrice, String paymentMethod, Integer amountProducts, List<ProductPersistenceRequestDTO> products) {
}
