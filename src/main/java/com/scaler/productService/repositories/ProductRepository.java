package com.scaler.productService.repositories;

import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    List<Product> findByCategory(Category category);
    List<Product> findByCategory_NameEquals(String  categoryName);
    //JPA Query
    @Query("select p from Product p where p.category.name= :categoryName")
    List<Product> getProductsBasedOnCategoryNames(@Param("categoryName") String categoryName);

    @Query(value = "select p.id, p.title, p.description, p.category_id, p.created_at, p.updated_at, p.is_deleted, p.image_url, p.price from product p join category c on p.category_id=c.id and c.name= :categoryName", nativeQuery = true)
    List<Product> getProductBasedOnCategoryNames2(@Param("categoryName") String categoryName);
}
