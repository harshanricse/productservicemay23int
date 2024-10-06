package com.scaler.productService;

import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import com.scaler.productService.repositories.CategoryRepository;
import com.scaler.productService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getProductsFromCategoryUsingTwoMethod(){
		Optional<Category> category = categoryRepository.findByName("electronics");
		List<Product> product = productRepository.findByCategory(category.get());
		System.out.println(product);
	}
	@Test
	public void getProductsFromCategoryUsingOneMethod(){
		List<Product> product = productRepository.findByCategory_NameEquals("electronics");
		System.out.println(product);
	}

	@Test
	public void getProductsFromCategoryUsingJpaQuery(){
		List<Product> product = productRepository.getProductsBasedOnCategoryNames("electronics");
		System.out.println(product);
	}
}
