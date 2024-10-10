package com.scaler.productService.controllers;

import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.dtos.ProductResponseDto;
import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import com.scaler.productService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @MockBean
    @Qualifier("productdbservice")
    private ProductService productService;
    @Autowired
    private ProductController productController;//class under test

    @Test
    public void testGetProductById() throws ProductNotFoundException {
        Product dummyProduct = new Product();
        dummyProduct.setTitle("mockTitle");
        dummyProduct.setDescription("mock Description");
        dummyProduct.setPrice(456.25);
        dummyProduct.setId(1L);
        dummyProduct.setImageUrl("mock image url");
        Category category = new Category();
        category.setName("mock category");
        dummyProduct.setCategory(category);
        when(productService.getProductById(1L)).
                thenReturn(dummyProduct);
        ProductResponseDto responseDto = productController.getProductById(1L);
        assertEquals(1L, responseDto.getId());
        assertEquals("mockTitle", responseDto.getTitle());
        assertEquals("mock Description", responseDto.getDescription());
        assertEquals(456.25,responseDto.getPrice());
        assertEquals("mock image url",responseDto.getImageUrl());
        assertEquals("mock category", responseDto.getCategoryName());
    }

    @Test
    public void testGetproductByIdProductIsNull() throws ProductNotFoundException{
        when(productService.getProductById(1L)).
                thenReturn(null);
        ProductResponseDto responseDto = productController.getProductById(1L);
        assertNull(responseDto);

    }

}