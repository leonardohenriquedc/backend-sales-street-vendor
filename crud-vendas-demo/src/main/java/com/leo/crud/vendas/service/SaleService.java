package com.leo.crud.vendas.service;

import com.leo.crud.vendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ProductsService productsService;

    @Autowired
    BankService bankService;

    @Transactional
    public SaleRequestInsertDTO insert(SaleRequestInsertDTO saleRequestInsertDTO){

    }

    @Transactional(readOnly = true)
    public ReportSalesDTO reportSales(LocalDate initDate, LocalDate finalDate, Long idProduct) {


    }

    public ResponseNewSaleDTO newSale(){
        List<BankDTO> banks = bankService.getAll();

        List<ProductsDTO> products = productsService.getAll();

        return new ResponseNewSaleDTO(banks, products);
    }
}