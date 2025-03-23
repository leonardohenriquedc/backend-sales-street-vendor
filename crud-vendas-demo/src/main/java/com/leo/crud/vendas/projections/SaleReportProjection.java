package com.leo.crud.vendas.projections;

import java.math.BigDecimal;

public interface SaleReportProjection {

    String getProduct();

    Integer getAmount();

    Double getUnitValue();

    Double getTotal();
}
