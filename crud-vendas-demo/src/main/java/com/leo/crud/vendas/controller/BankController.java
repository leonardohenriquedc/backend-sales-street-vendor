package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.requests.persistence.BankPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.BankPersistenceResponseDTO;
import com.leo.crud.vendas.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BankPersistenceResponseDTO> getBankOfTheRespectiveAccount(@RequestParam Long id){

        return ResponseEntity.ok(bankService.findById(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BankPersistenceResponseDTO> save(@RequestParam("name") String name, @RequestParam("keyPix") String pix, @RequestParam("file") MultipartFile file) throws IOException {

        BankPersistenceRequestDTO dto = new BankPersistenceRequestDTO(
            name,
            pix,
            file.getBytes()
        );

        BankPersistenceResponseDTO bankDTO = bankService.save(dto);

        return ResponseEntity.ok(bankDTO);
    }

    @GetMapping
    public ResponseEntity<List<BankPersistenceResponseDTO>> getAllBanks (){

        return ResponseEntity.ok(bankService.getAll());
    }
}
