package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.BankDTO;
import com.leo.crud.vendas.dto.ProductsDTO;
import com.leo.crud.vendas.dto.SaleDTO;
import com.leo.crud.vendas.entities.Bank;
import com.leo.crud.vendas.entities.Products;
import com.leo.crud.vendas.entities.Sale;
import com.leo.crud.vendas.exceptions.NotPossibleSave;
import com.leo.crud.vendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ProductsService productsService;

    @Autowired
    BankService bankService;

    public SaleDTO insert(SaleDTO saleDTO){
        Sale sale = new Sale();
        Products products = new Products();
        Bank bank = new Bank();

        sale.setQuantidade(saleDTO.getQuantidade());
        sale.setInitValue(saleDTO.getInitValue());
        sale.setTotalValue(saleDTO.getInitValue());
        sale.setDate(saleDTO.getDate());
        sale.setTotalValue(saleDTO.getTotalValue());

        ProductsDTO productsDTO = productsService.findById(saleDTO.getIdProduct());
        products.setId(productsDTO.getId());
        products.setName(productsDTO.getName());

        BankDTO bankDTO = bankService.findById(saleDTO.getIdBank());
        bank.setId(bankDTO.getId());
        bank.setName(bankDTO.getName());
        bank.setKeyPix(bankDTO.getKeyPix());

        sale.addProducts(products);
        sale.setBank(bank);

        try{

            sale = saleRepository.save(sale);

            return new SaleDTO(sale);

        } catch (Exception e) {

            throw new NotPossibleSave("Not possible save entity");

        }

    }
}
