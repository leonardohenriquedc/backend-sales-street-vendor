package com.leo.crud.vendas.dto.requests.persistence;

import com.leo.crud.vendas.validations.constraints.DateNotExceeding;
import com.leo.crud.vendas.validations.constraints.NotRetroactiveDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record SalePersistenceRequestDTO(

        @DateNotExceeding(message = "A data não pode ser superior a data atual")
        @NotRetroactiveDate(message = "A data não pode ser retroativa em relação a data atual")
        Date dateSale,

        @NotBlank(message = "Campo bankId não pode ser nulo")
        String bankId,

        @NotNull(message = "O campo preço total não pode ser nulo")
        BigDecimal totalPrice,

        @NotNull(message = "O campo metodo de pagamento não pode ser nulo")
        Long paymentMethod,

        @NotNull(message = "O campo quantidade de produtos não pode ser nulo")
        Integer amountProducts,

        List<ProductPersistenceRequestDTO> products
) {
}
