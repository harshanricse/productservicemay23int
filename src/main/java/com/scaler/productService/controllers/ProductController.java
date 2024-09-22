package com.scaler.productService.controllers;

import com.scaler.productService.dtos.ProductResponseDto;
import com.scaler.productService.models.Product;
import com.scaler.productService.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Log4j2
@RestController

public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/{id}")
    private ProductResponseDto getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = new ProductResponseDto().fromProduct(product);
        log.info("returning productResponseDto");
        return productResponseDto;
    }
    @GetMapping("/product")
    public String getAllProducts(){
        return "Hello World";

    }
    @PostMapping
    public void createProduct(){

    }
    @DeleteMapping
    public void deleteProduct(){

    }
}
