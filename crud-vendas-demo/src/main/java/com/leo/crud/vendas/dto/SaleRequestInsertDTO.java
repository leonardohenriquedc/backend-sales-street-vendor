package com.leo.crud.vendas.dto;

import com.leo.crud.vendas.entities.Sale;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class SaleRequestInsertDTO {

    private Long id;

    @Positive(message = "O valor do produto deve ser positivo")
    private Integer amount;

    @Positive(message = "O valor do produto deve ser positivo")
    private Double initValue;

    @NotNull(message = "Não pode ser vazio")
    private Long idProduct;

    @NotNull(message = "Não pode ser vazio")
    private Long idBank;

    private LocalDate date;

    public SaleRequestInsertDTO(Long id, Integer amount, Double initValue, Long idProduct, Long idBank, LocalDate localDate) {
        this.id = id;
        this.amount = amount;
        this.initValue = initValue;
        this.idProduct = idProduct;
        this.idBank = idBank;
        this.date = localDate;
    }

    public SaleRequestInsertDTO(Sale sale){
        id = sale.getId();
        amount = sale.getAmount();
        initValue = sale.getUnitValue();
        idProduct = sale.getProducts().getFirst().getId();
        idBank = sale.getBank().getId();
        date = sale.getDateSale();
    }

    public SaleRequestInsertDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getInitValue() {
        return initValue;
    }

    public void setInitValue(Double initValue) {
        this.initValue = initValue;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
