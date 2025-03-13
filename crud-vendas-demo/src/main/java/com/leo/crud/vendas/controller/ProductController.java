package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.ProductsDTO;
import com.leo.crud.vendas.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<ProductsDTO>> getAll(){

        return ResponseEntity.ok(productsService.getAll());
    }
}
