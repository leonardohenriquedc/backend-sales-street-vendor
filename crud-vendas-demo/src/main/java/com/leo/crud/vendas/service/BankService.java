package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.BankDTO;
import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
