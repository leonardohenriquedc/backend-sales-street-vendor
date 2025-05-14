package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.mirrors.entities.ProductDTO;
import com.leo.crud.vendas.dto.requests.persistence.ProductPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;
import com.leo.crud.vendas.entities.AmountProductStock;
import com.leo.crud.vendas.entities.Product;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.AmountProductStockRepository;
import com.leo.crud.vendas.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private AmountProductStockRepository amountProductStockRepository;

    @Autowired
    private GeneratedHash generatedHash;

    public ProductDTO getMirrorByExternalId(String id){

        Optional<Product> result = productsRepository.findByExternalId(id);

        if(result.isPresent()){
            return new ProductDTO(
                    result.get().getId(),
                    result.get().getExternalId(),
                    result.get().getName(),
                    result.get().getPrice()
            );
        }

        throw new ResourceNotFound("Produto não existe");
    }

    public ProductPersistenceResponseDTO findByExternalId(String id){
        System.out.println("Passou por aqui 0 ");

        Optional<Product> product = productsRepository.findByExternalId(id);

        System.out.println("Passou por aqui 1 ");

        if(product.isEmpty()) throw new ResourceNotFound("Recurso não existe");

        ProductPersistenceResponseDTO result =  new ProductPersistenceResponseDTO(
                product.get().getExternalId(),
                product.get().getName(),
                product.get().getPrice(),
                product.get().getAmountProductStock().getAmount()
        );

        System.out.println("Passou por aqui 2 ");
        System.out.println(result.name());
        return result;
    }

    public List<ProductPersistenceResponseDTO> getAll(){

        List<Product> result = productsRepository.findAll();

        return result.stream().map(x -> new ProductPersistenceResponseDTO(
                x.getExternalId(),
                x.getName(),
                x.getPrice(),
                x.getAmountProductStock().getAmount() != null ? x.getAmountProductStock().getAmount() : 0
        )).toList();
    }

    public ProductPersistenceResponseDTO newProduct( ProductPersistenceRequestDTO productPersistenceRequestDTO) {

        String externalId = generatedHash.generatedHash(productPersistenceRequestDTO.name(), productPersistenceRequestDTO.price().toString());

        Product product = new Product(
                null,
                externalId,
                productPersistenceRequestDTO.name(),
                productPersistenceRequestDTO.price()
        );

        product = productsRepository.save(product);

        AmountProductStock amountProductStock =
                new AmountProductStock(productPersistenceRequestDTO.amount());

        amountProductStock.setProduct(product);

        amountProductStockRepository.save(amountProductStock);

        return new ProductPersistenceResponseDTO(
                product.getExternalId(),
                product.getName(),
                product.getPrice(),
                amountProductStock.getAmount()
        );
    }

    public ProductPersistenceResponseDTO updateProduct(String id, ProductPersistenceRequestDTO dto) {

        Optional<Product> result = productsRepository.findByExternalId(id);

        if(result.isEmpty()) throw new ResourceNotFound("Recurso não encontrado");

        Product product = productsRepository.getReferenceById(result.get().getId());

        product.setName(dto.name());
        product.setPrice(dto.price());
        product.getAmountProductStock().setAmount(dto.amount());

        product = productsRepository.save(product);

        return new ProductPersistenceResponseDTO(
                product.getExternalId(),
                product.getName(),
                product.getPrice(),
                product.getAmountProductStock().getAmount()
        );
    }

    public void delete(String id) {
        Optional<Product> product = productsRepository.findByExternalId(id);

        if(product.isEmpty()) throw new ResourceNotFound("Impossivel delete recurso inexistente");

        productsRepository.delete(product.get());
    }
}
