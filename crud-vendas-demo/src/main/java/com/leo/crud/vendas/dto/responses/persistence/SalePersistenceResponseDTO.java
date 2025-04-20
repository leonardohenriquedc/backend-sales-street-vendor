package com.leo.crud.vendas.dto.responses.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record SalePersistenceResponseDTO(String id, Integer amountProducts, BigDecimal totalPrice, List<ProductPersistenceResponseDTO> products, Date dateSale, String paymentMethod) {
}
