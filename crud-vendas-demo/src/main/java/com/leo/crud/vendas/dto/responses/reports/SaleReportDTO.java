package com.leo.crud.vendas.dto.responses.reports;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.leo.crud.vendas.dto.responses.persistence.SalePersistenceResponseDTO;

public record SaleReportDTO(Date initDate, Date finalDate, List<SalePersistenceResponseDTO> sales) {
}
