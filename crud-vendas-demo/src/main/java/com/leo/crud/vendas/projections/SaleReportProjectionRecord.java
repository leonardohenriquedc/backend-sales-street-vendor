package com.leo.crud.vendas.projections;

public record SaleReportProjectionRecord(String product, Integer amount, Double unitValue, Double total) {
}
