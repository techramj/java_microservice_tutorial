package com.easylearning.productservice.controller;

import lombok.RequiredArgsConstructor;
import com.easylearning.productservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.easylearning.productservice.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    //@ResponseStatus(HttpStatus.OK)
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product){
        productRepository.save(product);
    }



}
