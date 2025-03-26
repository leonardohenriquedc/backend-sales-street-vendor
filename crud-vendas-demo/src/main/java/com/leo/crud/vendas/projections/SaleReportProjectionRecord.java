package com.leo.crud.vendas.projections;

public record SaleReportProjectionRecord(String product, Long amount, Double unitValue, Double total) {
}
