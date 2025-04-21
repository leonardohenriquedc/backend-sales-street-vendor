package com.leo.crud.vendas.dto.responses.agroups;

import java.util.List;
import com.leo.crud.vendas.dto.responses.persistence.BankPersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;

public record NewSaleAgroup(List<BankPersistenceResponseDTO> banks, List<ProductPersistenceResponseDTO> products) {
}
