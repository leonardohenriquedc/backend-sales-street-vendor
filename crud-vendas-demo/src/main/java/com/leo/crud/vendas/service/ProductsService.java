package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.requests.persistence.ProductPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;
import com.leo.crud.vendas.entities.Product;
import com.leo.crud.vendas.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    public ProductPersistenceResponseDTO findById(Long id){

        return null;
    }

    public List<ProductPersistenceResponseDTO> getAll(){

        List<Product> result = productsRepository.findAll();

        return result.stream().map(x -> new ProductPersistenceResponseDTO(
                x.getExternalId(),
                x.getName(),
                x.getPrice()
        )).toList();
    }
}
