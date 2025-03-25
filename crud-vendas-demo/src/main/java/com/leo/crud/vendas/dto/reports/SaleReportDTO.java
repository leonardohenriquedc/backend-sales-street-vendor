package com.leo.crud.vendas.dto.reports;

public class SaleReportDTO implements SaleReportProjection{

    private String product;

    private Integer amount;

    private Double unitValue;

    private Double total;

    public SaleReportDTO(String product, Integer amount, Double unitValue, Double total) {
        this.product = product;
        this.amount = amount;
        this.unitValue = unitValue;
        this.total = total;
    }

    public SaleReportDTO(SaleReportProjection saleReportProjection){
        product = saleReportProjection.getProduct();
        amount = saleReportProjection.getAmount();
        unitValue = saleReportProjection.getUnitValue();
        total = saleReportProjection.getTotal();
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
        this.total = unitValue * quantidade;
    }
}
