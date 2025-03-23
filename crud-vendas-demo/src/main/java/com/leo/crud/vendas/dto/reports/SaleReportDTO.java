package com.leo.crud.vendas.dto.reports;

import com.leo.crud.vendas.projections.SaleReportProjection;

public class SaleReportDTO {

    private String product;

    private Integer amount;

    private Double unitValue;

    private Double totalValue;

    public SaleReportDTO(String product, Integer amount, Double unitValue, Double totalValue) {
        this.product = product;
        this.amount = amount;
        this.unitValue = unitValue;
        this.totalValue = totalValue;
    }

    public SaleReportDTO(SaleReportProjection saleReportProjection){
        product = saleReportProjection.getProduct();
        amount = saleReportProjection.getAmount();
        unitValue = saleReportProjection.getUnitValue();
        totalValue = saleReportProjection.getTotal();
    }

    public SaleReportDTO(){
    }

    public Double getTotalValue(){
        return totalValue;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public void setTotalValue(Double unitValue, Integer quantidade) {
        this.totalValue = unitValue * quantidade;
    }
}
