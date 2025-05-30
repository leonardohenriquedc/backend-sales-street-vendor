package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.BankDTO;
import com.leo.crud.vendas.dto.requests.persistence.BankPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.BankPersistenceResponseDTO;
import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    protected BankDTO getMirrorBankByExternalId(String id){

        Optional<Bank> result = bankRepository.findByExternalId(id);

        if(result.isPresent()){

            return new BankDTO(
                    result.get().getId(),
                    result.get().getExternalId(),
                    result.get().getName(),
                    result.get().getKeyPix(),
                    result.get().getImgQrCode()
            );
        }

        throw new ResourceNotFound("Bank Id not found");
    }

    public BankPersistenceResponseDTO findByExternalId(String externalId){

        Optional<Bank> existsId = bankRepository.findByExternalId(externalId);

        if(existsId.isPresent()){

            return new BankPersistenceResponseDTO(
                    existsId.get().getExternalId(),
                    existsId.get().getName(),
                    existsId.get().getKeyPix(),
                    existsId.get().getImgQrCode()
            );
        }

        throw new ResourceNotFound("Id not found");

    }

    public BankPersistenceResponseDTO save(BankPersistenceRequestDTO dto) {

        Bank bank = new Bank();

        bank.setName(dto.name());
        bank.setKeyPix(dto.keyPix());
        bank.setImgQrCode(dto.imgQrCode());

        bank = bankRepository.save(bank);

        return new BankPersistenceResponseDTO(
                bank.getExternalId(),
                bank.getName(),
                bank.getKeyPix(),
                bank.getImgQrCode()
        );
    }

    public List<BankPersistenceResponseDTO> getAll(){
        List<Bank> result = bankRepository.findAll();

        List<BankPersistenceResponseDTO> banks = result.stream().map(bank -> new BankPersistenceResponseDTO(
                bank.getExternalId(),
                bank.getName(),
                bank.getKeyPix(),
                null
        )).toList();

        return banks;
    }
}