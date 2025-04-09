package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.BankDTO;
import com.leo.crud.vendas.dto.ProductsDTO;
import com.leo.crud.vendas.dto.ResponseNewSaleDTO;
import com.leo.crud.vendas.dto.SaleRequestInsertDTO;
import com.leo.crud.vendas.dto.reports.ReportSalesDTO;
import com.leo.crud.vendas.dto.reports.SaleReportDTO;
import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.entities.Product;
import com.leo.crud.vendas.entities.Sale;
import com.leo.crud.vendas.exceptions.NotExistsResources;
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
        Product product = new Product();
        Bank bank = new Bank();

        sale.setAmount(saleRequestInsertDTO.getAmount());
        sale.setUnitValue(saleRequestInsertDTO.getInitValue());
        sale.setDateSale(saleRequestInsertDTO.getDate());

        ProductsDTO productsDTO = productsService.findById(saleRequestInsertDTO.getIdProduct());
        product.setId(productsDTO.getId());
        product.setName(productsDTO.getName());

        BankDTO bankDTO = bankService.findById(saleRequestInsertDTO.getIdBank());
        bank.setId(bankDTO.getId());
        bank.setName(bankDTO.getName());
        bank.setKeyPix(bankDTO.getKeyPix());

        sale.addProducts(product);
        sale.setBank(bank);

        try{

            sale = saleRepository.save(sale);

            return new SaleRequestInsertDTO(sale);

        } catch (Exception e) {

            throw new NotPossibleSave("Not possible save entity");

        }

    }

    @Transactional(readOnly = true)
    public ReportSalesDTO reportSales(LocalDate initDate, LocalDate finalDate, Long idProduct) {

        if (initDate == null || finalDate == null || idProduct == null) {
            throw new IllegalArgumentException("Parâmetros não podem ser nulos!");
        }

        if (initDate.isAfter(finalDate)) {
            throw new IllegalArgumentException("A data inicial não pode ser maior que a data final!");
        }

        System.out.println("Estas são as datas e id: " + initDate + ", " + finalDate + ", " + idProduct);

        List<SaleReportProjectionRecord> result = saleRepository.searchReportSales(initDate, finalDate, idProduct);

        System.out.println(result.toString());

        if (result.isEmpty()) {
            throw new NotExistsResources();
        }

        return new ReportSalesDTO(result);
    }

    public ResponseNewSaleDTO newSale(){
        List<BankDTO> banks = bankService.getAll();

        List<ProductsDTO> products = productsService.getAll();

        return new ResponseNewSaleDTO(banks, products);
    }
}