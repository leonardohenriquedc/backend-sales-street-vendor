package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.BankDTO;
import com.leo.crud.vendas.dto.ProductsDTO;
import com.leo.crud.vendas.dto.SaleRequestInsertDTO;
import com.leo.crud.vendas.dto.reports.ReportSalesDTO;
import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.entities.Products;
import com.leo.crud.vendas.entities.Sale;
import com.leo.crud.vendas.exceptions.NotPossibleSave;
import com.leo.crud.vendas.projections.SaleReportProjectionRecord;
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
        Sale sale = new Sale();
        Products products = new Products();
        Bank bank = new Bank();

        sale.setAmount(saleRequestInsertDTO.getAmount());
        sale.setUnitValue(saleRequestInsertDTO.getInitValue());
        sale.setDateSale(saleRequestInsertDTO.getDate());

        ProductsDTO productsDTO = productsService.findById(saleRequestInsertDTO.getIdProduct());
        products.setId(productsDTO.getId());
        products.setName(productsDTO.getName());

        BankDTO bankDTO = bankService.findById(saleRequestInsertDTO.getIdBank());
        bank.setId(bankDTO.getId());
        bank.setName(bankDTO.getName());
        bank.setKeyPix(bankDTO.getKeyPix());

        sale.addProducts(products);
        sale.setBank(bank);

        try{

            sale = saleRepository.save(sale);

            return new SaleRequestInsertDTO(sale);

        } catch (Exception e) {

            throw new NotPossibleSave("Not possible save entity");

        }

    }

    @Transactional(readOnly = true)
    public ReportSalesDTO reportSales(String initDateS, String finalDateS, String idProductS){

        LocalDate initDate = LocalDate.parse(initDateS);

        LocalDate finalDate = LocalDate.parse(finalDateS);
        Long idProduct = Long.parseLong(idProductS);


        System.out.println("Este são as datas e id: " + initDate + ", " + finalDate + ", " + idProduct);

        List<SaleReportProjectionRecord> result = saleRepository.searchReportSales(finalDate, initDate, idProduct);

        System.out.println(result.toString());

        return new ReportSalesDTO(result);
    }
}