package com.scaler.productService.controllers;

import com.scaler.productService.dtos.ProductResponseDto;
import com.scaler.productService.models.Product;
import com.scaler.productService.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
