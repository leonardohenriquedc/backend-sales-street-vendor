package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.requests.persistence.SalePersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.agroups.NewSaleAgroup;
import com.leo.crud.vendas.dto.responses.persistence.BankPersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.persistence.SalePersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.reports.SaleReportDTO;
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
    public SalePersistenceResponseDTO insert(SalePersistenceRequestDTO saleRequestInsertDTO){
        return null;
    }

    @Transactional(readOnly = true)
    public SaleReportDTO reportSales(LocalDate initDate, LocalDate finalDate, Long idProduct) {

        return null;
    }

    public NewSaleAgroup newSale(){
        List<BankPersistenceResponseDTO> banks = bankService.getAll();

        List<ProductPersistenceResponseDTO> products = productsService.getAll();

        return new NewSaleAgroup(banks, products);
    }
}