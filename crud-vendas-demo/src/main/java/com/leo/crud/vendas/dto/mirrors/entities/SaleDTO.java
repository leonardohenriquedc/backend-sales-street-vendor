package com.leo.crud.vendas.dto.mirrors.entities;

import java.math.BigDecimal;
import java.util.Date;

public record SaleDTO(Long id, String externalId, Date dateSale, BankDTO bank, BigDecimal totalPrice, PaymentMethodDTO paymentMethod ) {
}
