package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.SaleDTO;
import com.leo.crud.vendas.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> insert(@Valid @RequestBody SaleDTO saleDTO){
        saleDTO = saleService.insert(saleDTO);

        return ResponseEntity.ok(saleDTO);
    }
}
