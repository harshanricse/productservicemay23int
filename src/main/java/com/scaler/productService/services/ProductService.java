package com.scaler.productService.services;

import com.scaler.productService.models.Product;

public interface ProductService {
    // we are returning Product model not ProductResponseDto bcz we want our services to be generic i.e can be called by anyone
    public Product getProductById(Long id);
}
