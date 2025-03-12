package com.leo.crud.vendas.dto;

import com.leo.crud.vendas.entities.Products;

public class ProductsDTO {

    Long id;

    String name;

    public ProductsDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductsDTO(Products products){

        id = products.getId();

        name = products.getName();
    }

    public ProductsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
