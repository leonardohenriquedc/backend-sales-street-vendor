package com.leo.crud.vendas.controller;

import com.leo.crud.vendas.dto.requests.persistence.ProductPersistenceRequestDTO;
import com.leo.crud.vendas.dto.responses.persistence.ProductPersistenceResponseDTO;
import com.leo.crud.vendas.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<ProductPersistenceResponseDTO>> getAll(){

        return ResponseEntity.ok(productsService.getAll());
    }

    @PostMapping(value = "/new")
    public ResponseEntity newProduct(@RequestBody @Valid ProductPersistenceRequestDTO productPersistenceRequestDTO){
        ProductPersistenceResponseDTO result = productsService.newProduct(productPersistenceRequestDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/product/{id}")
                .buildAndExpand(result.id()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductPersistenceResponseDTO> getProduct(@PathVariable String id){
        return ResponseEntity.ok(productsService.findByExternalId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductPersistenceResponseDTO>updateProduct(@PathVariable String id, @RequestBody @Valid ProductPersistenceRequestDTO productPersistenceRequestDTO){
        return ResponseEntity.ok(productsService.updateProduct(id, productPersistenceRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        productsService.delete(id);

        return ResponseEntity.ok().build();
    }
}
