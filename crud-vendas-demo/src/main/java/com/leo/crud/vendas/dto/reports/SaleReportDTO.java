package com.leo.crud.vendas.dto.reports;

import com.leo.crud.vendas.projections.SaleReportProjectionRecord;

public class SaleReportDTO {

    private String product;

    private Long amount;

    private Double unitValue;

    private Double total;

    public SaleReportDTO(String product, Long amount, Double unitValue, Double total) {
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

    public Double getTotal(){
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

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public void setTotalValue(Double unitValue, Integer quantidade) {
        this.total = unitValue * quantidade;
    }
}
