package com.leo.crud.vendas.service;

import com.leo.crud.vendas.dto.ProductsDTO;
import com.leo.crud.vendas.entities.Products;
import com.leo.crud.vendas.exceptions.ResourceNotFound;
import com.leo.crud.vendas.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducsService {

    @Autowired
    ProductsRepository productsRepository;

    public ProductsDTO findById(Long id){

        Optional<Products> existsId = productsRepository.findById(id);

        if(existsId.isPresent()){

            return new ProductsDTO(existsId.get());

        }else {

            throw new ResourceNotFound("Id not found");
        }
    }
}
