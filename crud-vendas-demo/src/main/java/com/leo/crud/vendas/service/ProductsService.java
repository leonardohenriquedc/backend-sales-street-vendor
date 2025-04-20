package com.leo.crud.vendas.service;

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

    public ProductsDTO findById(Long id){


    }

    public List<ProductsDTO> getAll(){

        List<Product> result = productsRepository.findAll();

        List<ProductsDTO> productsDTOS = result.stream().map(x -> new ProductsDTO(x)).collect(Collectors.toUnmodifiableList());

        return productsDTOS;
    }
}
