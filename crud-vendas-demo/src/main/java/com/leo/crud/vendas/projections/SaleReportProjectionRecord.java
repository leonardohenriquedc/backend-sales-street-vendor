//package com.leo.crud.vendas.projections;
//
//public record SaleReportProjectionRecord(String product, Long amount, Double unitValue, Double total) {
//}
package com.leo.crud.vendas.projections;

import java.math.BigDecimal;

public record SaleReportProjectionRecord(String product, Long amount, BigDecimal unitValue, BigDecimal total) {
}
