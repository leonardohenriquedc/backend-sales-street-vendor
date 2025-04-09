package com.leo.crud.vendas.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseNewSaleDTO {
    List<BankDTO> banks = new ArrayList<>();

    List<ProductsDTO> products = new ArrayList<>();

    public ResponseNewSaleDTO(List<BankDTO> banks, List<ProductsDTO> products) {
        this.banks = banks;
        this.products = products;
    }

    public ResponseNewSaleDTO() {
    }

    public List<BankDTO> getBanks() {
        return banks;
    }

    public void setBanks(List<BankDTO> banks) {
        this.banks = banks;
    }

    public List<ProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsDTO> products) {
        this.products = products;
    }
}
