package com.scaler.productService.services;

import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.ProductServiceApplication;
import com.scaler.productService.models.Product;

import java.util.List;

public interface ProductService {
    // we are returning Product model not ProductResponseDto bcz we want our services to be generic i.e can be called by anyone
    public Product getProductById(Long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product createProduct(String title, Double price, String description, String image, String category);
}
