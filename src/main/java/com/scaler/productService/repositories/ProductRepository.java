package com.scaler.productService.repositories;

import com.scaler.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
}
