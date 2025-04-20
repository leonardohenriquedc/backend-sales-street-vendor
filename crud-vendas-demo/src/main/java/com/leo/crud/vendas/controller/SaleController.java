package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleRequestInsertDTO> insert(@Valid @RequestBody SaleRequestInsertDTO saleRequestInsertDTO){
        saleRequestInsertDTO = saleService.insert(saleRequestInsertDTO);

        return ResponseEntity.ok(saleRequestInsertDTO);
    }

    @PostMapping(value = "/reportsales")
    public ResponseEntity<ReportSalesDTO> reportSales(
            @RequestParam(name = "initDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate initDate,

            @RequestParam(name = "finalDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finalDate,

            @RequestParam(name = "productId") Long productId
    ) {
        ReportSalesDTO report = saleService.reportSales(initDate, finalDate, productId);
        return ResponseEntity.ok(report);
    }

    @GetMapping(value = "/newsale")
    public ResponseEntity<ResponseNewSaleDTO> newSale(){
        return ResponseEntity.ok(saleService.newSale());
    }
}
