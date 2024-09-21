package com.scaler.productService.dtos;

import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setDescription(this.description);
        product.setTitle(this.title);
        product.setPrice(Double.valueOf(this.price));
        product.setImageUrl(this.image);
        Category category1 = new Category();
        category1.setName(this.category);
        product.setCategory(category1);
        return product;

    }
}
