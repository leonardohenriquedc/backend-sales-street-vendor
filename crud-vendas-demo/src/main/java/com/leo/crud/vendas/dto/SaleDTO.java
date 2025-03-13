package com.leo.crud.vendas.dto;

import com.leo.crud.vendas.entities.Sale;

public class SaleDTO {

    private Long id;

    private Long quantidade;

    private Double initValue;

    private Long idProduct;

    private Long idBank;

    public SaleDTO(Long id, Long quantidade, Double initValue, Long idProduct, Long idBank) {
        this.id = id;
        this.quantidade = quantidade;
        this.initValue = initValue;
        this.idProduct = idProduct;
        this.idBank = idBank;
    }

    public SaleDTO(Sale sale){

        id = sale.getId();

        quantidade = sale.getQuantidade();

        initValue = sale.getInitValue();

        idProduct = sale.getProducts().getFirst().getId();

        idBank = sale.getBank().getId();
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
}
