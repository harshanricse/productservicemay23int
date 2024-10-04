package com.scaler.productService.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.models.Product;
import java.util.List;

@Primary
@Service("productdbservice")
public class ProductDBService implements ProductService {
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String category) {
        return null;
    }
}
