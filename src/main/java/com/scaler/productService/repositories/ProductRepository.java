package com.scaler.productService.repositories;

import com.scaler.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    /*
    save method is used for both saving and updating
    if Id is present, it will update
    if Id is not present, it will insert
     */

    Product save(Product product);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long aLong);
}
