package com.scaler.productService.controllers;

import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.commons.AuthenticationCommons;
import com.scaler.productService.dtos.ErrorDto;
import com.scaler.productService.dtos.ProductRequestDto;
import com.scaler.productService.dtos.ProductResponseDto;
import com.scaler.productService.dtos.UserDto;
import com.scaler.productService.models.Product;
import com.scaler.productService.services.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController

public class ProductController {
    private ProductService productService;
    private AuthenticationCommons authenticationCommons;
    public ProductController(@Qualifier("fakestoreservice") ProductService productService, AuthenticationCommons authenticationCommons){
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }
    @GetMapping("/product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) throws ProductNotFoundException {
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto==null){
            throw new RuntimeException("Invalid token");
        }
        Product product = productService.getProductById(id);
        ProductResponseDto productResponseDto = new ProductResponseDto().fromProduct(product);
        log.info("returning productResponseDto");
        return productResponseDto;
    }
    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        //converting products to productResponseDtos
        for(Product product: products){
            productResponseDtos.add(ProductResponseDto.fromProduct(product));
        }
        return productResponseDtos;

    }
    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = productService.createProduct(productRequestDto.getTitle(), productRequestDto.getPrice(), productRequestDto.getDescription(), productRequestDto.getImage(), productRequestDto.getCategory());
        return ProductResponseDto.fromProduct(product);
    }
    @PatchMapping("/product/{id}")
    public ProductResponseDto updateProduct(@PathVariable("id") Long id ,@RequestBody ProductRequestDto productRequestDto) throws ProductNotFoundException {
        Product product = productService.partialUpdateById(id, productRequestDto.toProduct(productRequestDto));
        return ProductResponseDto.fromProduct(product);
    }
    @DeleteMapping
    public void deleteProduct(){

    }
    /*
    only invoked in productController class.
    If there is any controller that throws NPE, this won't be called
     */
//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDto nullpointerexceptionhandler(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("Something went wrong");
//        errorDto.setStatus("Failure");
//        return errorDto;
//    }
}
