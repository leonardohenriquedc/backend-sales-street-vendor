package com.leo.crud.vendas.service;

import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public BankDTO findById(Long id){

        Optional<Bank> existsId = bankRepository.findById(id);

        if(existsId.isPresent()){

            return new BankDTO(existsId.get());
        }else {

            throw new ResourceNotFound("Id not found");
        }
    }

    public BankDTO save(CreateBankDTO dto) {

        try {
            Bank bank = new Bank();

            byte[] image = dto.getImageQrCode().getBytes();

            bank.setName(dto.getName());
            bank.setKeyPix(dto.getKeyPix());
            bank.setImgQrCode(image);

            bank = bankRepository.save(bank);

            return new BankDTO(bank);
        }catch (IOException e){
            throw new RuntimeException("Erro de IO");
        }
    }

    public List<BankDTO> getAll(){
        List<Bank> result = bankRepository.findAll();

        List<BankDTO> bankDTOS = result.stream().map(BankDTO::new).collect(Collectors.toList());

        bankDTOS.forEach(b-> b.setImgQrCode(null));

        return bankDTOS;
    }
}