package com.leo.crud.vendas.dto;

import com.leo.crud.vendas.entities.Sale;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class SaleDTO {

    private Long id;

    @Positive(message = "O valor do produto deve ser positivo")
    private Long quantidade;

    @Positive(message = "O valor do produto deve ser positivo")
    private Double initValue;

    @NotNull(message = "Não pode ser vazio")
    private Long idProduct;

    @NotNull(message = "Não pode ser vazio")
    private Long idBank;

    private Double totalValue;

    private LocalDate date;

    public SaleDTO(Long id, Long quantidade, Double initValue, Long idProduct, Long idBank, Double totalValue, LocalDate localDate) {
        this.id = id;
        this.quantidade = quantidade;
        this.initValue = initValue;
        this.idProduct = idProduct;
        this.idBank = idBank;
        this.totalValue = totalValue;
        this.date = localDate;
    }

    public SaleDTO(Sale sale){
        id = sale.getId();
        quantidade = sale.getQuantidade();
        initValue = sale.getInitValue();
        idProduct = sale.getProducts().getFirst().getId();
        idBank = sale.getBank().getId();
        totalValue = sale.getTotalValue();
        date = sale.getDate();
    }

    public SaleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
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

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
