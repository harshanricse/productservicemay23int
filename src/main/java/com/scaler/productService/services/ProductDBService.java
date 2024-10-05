package com.scaler.productService.services;

import com.scaler.productService.models.Category;
import com.scaler.productService.repositories.CategoryRepository;
import com.scaler.productService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.models.Product;
import java.util.List;
import java.util.Optional;

@Primary
@Service("productdbservice")
public class ProductDBService implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with id: "+id+" not found ");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String categoryName) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setCategory(getCategoryFromDB(categoryName));
        return productRepository.save(product);
    }

    @Override
    public Product partialUpdateById(Long id,Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with Id "+id+"doesn't exist");
        }
        Product productToUpdate = productOptional.get();
        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getDescription()!=null){
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            productToUpdate.setPrice(product.getPrice());
        }
        if(product.getImageUrl()!=null){
            productToUpdate.setImageUrl(product.getImageUrl());
        }
        System.out.println("Welcome");
        System.out.println(product.getCategory().getName());
        //updating category
        if(product.getCategory().getName()!=null){
            productToUpdate.setCategory(getCategoryFromDB(product.getCategory().getName()));
        }
        return productRepository.save(productToUpdate);
    }

    private Category getCategoryFromDB(String categoryName){
        Optional<Category> categoryOptional= categoryRepository.findByName(categoryName);
        if(categoryOptional.isEmpty()){
            Category category = new Category();
            category.setName(categoryName);
            return categoryRepository.save(category);
        }
        return categoryOptional.get();
    }
}
