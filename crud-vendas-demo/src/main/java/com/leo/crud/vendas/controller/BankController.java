package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BankDTO> getBankOfTheRespectiveAccount(@RequestParam Long id){

        return ResponseEntity.ok(bankService.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BankDTO> save(@RequestParam("name") String name, @RequestParam("keyPix") String pix, @RequestParam("file") MultipartFile file){

        CreateBankDTO dto = new CreateBankDTO();

        dto.setName(name);
        dto.setKeyPix(pix);
        dto.setImageQrCode(file);

        BankDTO bankDTO = bankService.save(dto);

        return ResponseEntity.ok(bankDTO);
    }

    @GetMapping
    public ResponseEntity<List<BankDTO>> getAllBanks (){

        return ResponseEntity.ok(bankService.getAll());
    }
}
