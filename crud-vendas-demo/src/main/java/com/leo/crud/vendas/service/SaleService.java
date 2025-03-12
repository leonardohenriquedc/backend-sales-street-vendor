package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.SaleDTO;
import com.leo.crud.vendas.entities.Sale;
import com.leo.crud.vendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public boolean insert(SaleDTO saleDTO){
        Sale sale = new Sale();

        sale.setQuantidade(saleDTO.getQuantidade());

        sale.setInitValue(saleDTO.getInitValue());


    }
}
