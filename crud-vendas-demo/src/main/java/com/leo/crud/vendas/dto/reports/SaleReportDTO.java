package com.leo.crud.vendas.dto.reports;

import com.leo.crud.vendas.projections.SaleReportProjectionRecord;

import java.math.BigDecimal;

public class SaleReportDTO {

    private String product;

    private Long amount;

    private BigDecimal unitValue;

    private BigDecimal total;

    public SaleReportDTO(String product, Long amount, BigDecimal unitValue, BigDecimal total) {
        this.product = product;
        this.amount = amount;
        this.unitValue = unitValue;
        this.total = total;
    }

    public SaleReportDTO(SaleReportProjectionRecord saleReportProjection){
        product = saleReportProjection.product();
        amount = saleReportProjection.amount();
        unitValue = saleReportProjection.unitValue();
        total = saleReportProjection.total();
    }

    public SaleReportDTO(){
    }

    public BigDecimal getTotal(){
        return total;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigDecimal unitValue) {
        this.unitValue = unitValue;
    }

    public void setTotalValue(BigDecimal unitValue, Integer quantidade) {
        this.total = unitValue.multiply(new BigDecimal(quantidade));
    }
}
