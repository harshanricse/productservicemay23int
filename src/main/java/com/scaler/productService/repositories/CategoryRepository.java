package com.scaler.productService.repositories;

import com.scaler.productService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
    Optional<Category> findByName(String name);
    Optional<Category> findById(Long id);
}
