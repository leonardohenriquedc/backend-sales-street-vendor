package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.requests.persistence.SalePersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.agroups.NewSaleAgroup;
import com.leo.crud.vendas.dto.responses.persistence.SalePersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.reports.SaleReportDTO;
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
    public ResponseEntity<SalePersistenceResponseDTO> insert(@RequestBody @Valid SalePersistenceRequestDTO saleRequestInsertDTO){
        SalePersistenceResponseDTO salePersistenceResponseDTO = saleService.insert(saleRequestInsertDTO);

        return ResponseEntity.ok(salePersistenceResponseDTO);
    }

    @GetMapping(value = "/get-infos-new-sale")
    public ResponseEntity<NewSaleAgroup> newSale(){
        return ResponseEntity.ok(saleService.getInfosNewSale());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSale(@PathVariable String id){
         saleService.delete(id);

         return ResponseEntity.ok().build();
    }
}
