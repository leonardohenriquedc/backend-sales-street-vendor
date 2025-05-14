package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.BankDTO;
import com.leo.crud.vendas.dto.mirrors.entities.PaymentMethodDTO;
import com.leo.crud.vendas.dto.mirrors.entities.ProductDTO;
import com.leo.crud.vendas.dto.mirrors.entities.SaleDTO;
import com.leo.crud.vendas.dto.requests.persistence.SalePersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.agroups.NewSaleAgroup;
import com.leo.crud.vendas.dto.responses.persistence.BankPersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.persistence.SalePersistenceResponseDTO;
import com.leo.crud.vendas.dto.responses.reports.SaleReportDTO;
import com.leo.crud.vendas.entities.*;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.ProductAmountRepository;
import com.leo.crud.vendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ProductAmountRepository productAmountRepository;

    @Autowired
    ProductsService productsService;

    @Autowired
    BankService bankService;

    @Autowired
    PaymentMethodService payemnts;

    @Autowired
    GeneratedHash generatedHash;

    @Transactional
    public SalePersistenceResponseDTO insert(SalePersistenceRequestDTO saleRequestInsertDTO){

        BankDTO result = bankService.getMirrorBankByExternalId(saleRequestInsertDTO.bankId());

        PaymentMethodDTO resultPayment = payemnts.getMirrorById(saleRequestInsertDTO.paymentMethodId());

        PaymentMethod paymentMethod = new PaymentMethod(
                resultPayment.id(),
                resultPayment.method()
        );

        Bank bank = new Bank(
                result.id(),
                result.name(),
                result.keyPix(),
                result.imgQrCode()
        );

        bank.setExternalId(result.externalId());

        Sale sale = new Sale();
        sale.setAmountProducts(saleRequestInsertDTO.amountProducts());
        sale.setTotalPrice(saleRequestInsertDTO.totalPrice());
        sale.setDateSale(saleRequestInsertDTO.dateSale());
        sale.setBank(bank);
        sale.setPaymentMethod(paymentMethod);

        String externalId = generatedHash.generatedHash(
          sale.getDateSale().toString(),
          sale.getPaymentMethod().getId().toString(),
          sale.getBank().getId().toString(),
          sale.getTotalPrice().toString(),
          sale.getAmountProducts().toString()
        );

        sale.setExternalId(externalId);

        sale = saleRepository.save(sale);


        Sale finalSale = sale;
        List<ProductAmount> productAmounts = saleRequestInsertDTO.products().stream().map(x -> {
            ProductDTO productDTO = productsService.getMirrorByExternalId(x.id());

            Product product = new Product(
                    productDTO.id(),
                    productDTO.externalId(),
                    productDTO.name(),
                    productDTO.price()
            );

            ProductAmount productAmount = new ProductAmount(x.amount(), product.getPrice());
            productAmount.setSale(finalSale);
            productAmount.setProduct(product);

            return productAmountRepository.save(productAmount);
        }).toList();

        List<ProductPersistenceResponseDTO> productPersistenceResponseDTOS = productAmounts.stream()
                .map(x -> new ProductPersistenceResponseDTO(
                        x.getProduct().getExternalId(),
                        x.getProduct().getName(),
                        x.getProduct().getPrice(),
                        x.getProduct().getAmountProductStock().getAmount()
                        )
                ).toList();

        return new SalePersistenceResponseDTO(
                sale.getExternalId(),
                sale.getAmountProducts(),
                sale.getTotalPrice(),
                productPersistenceResponseDTOS,
                sale.getDateSale(),
                sale.getPaymentMethod().getMethod()
        );
    }

    @Transactional(readOnly = true)
    public SaleReportDTO reportSales(LocalDate initDate, LocalDate finalDate, Long idProduct) {

        return null;
    }

    public NewSaleAgroup getInfosNewSale(){
        List<BankPersistenceResponseDTO> banks = bankService.getAll();

        List<ProductPersistenceResponseDTO> products = productsService.getAll();

        List<PaymentMethodDTO> paymentMethod = payemnts.getAll();

        return new NewSaleAgroup(banks, products, paymentMethod);
    }

    public void delete(String id) {


        Sale sale = saleRepository.findByExternalId(id)
                .orElseThrow(() -> new ResourceNotFound("Impossível deletar recurso inexistente"));

        ProductAmount productAmount = productAmountRepository.findBySaleId(sale.getId())
                .orElseThrow(() -> new ResourceNotFound("Associação venda produto inexistente"));

        productAmountRepository.delete(productAmount);
    }
}