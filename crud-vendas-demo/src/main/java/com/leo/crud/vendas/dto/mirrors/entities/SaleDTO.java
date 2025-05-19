package com.leo.crud.vendas.dto.mirrors.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public record SaleDTO(
  Long id, 
  String externalId, 
  LocalDate dateSale,
  BankDTO bank, 
  BigDecimal totalPrice, 
  PaymentMethodDTO paymentMethod 
) {
}
