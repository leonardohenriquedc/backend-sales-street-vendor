package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.SaleRequestInsertDTO;
import com.leo.crud.vendas.dto.reports.ReportSalesDTO;
import com.leo.crud.vendas.service.SaleService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
            @RequestParam(name = "initDate") String initDate,
            @RequestParam(name = "finalDate") String finalDate,
            @RequestParam(name = "productId") String productId
    ){

        ReportSalesDTO reportSalesDTO = saleService.reportSales(initDate, finalDate, productId);

        return ResponseEntity.ok(reportSalesDTO);
    }
}
