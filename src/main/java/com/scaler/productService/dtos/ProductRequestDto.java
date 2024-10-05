package com.scaler.productService.dtos;

import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setDescription(productRequestDto.description);
        product.setTitle(productRequestDto.title);
        if(productRequestDto.price!=null) {
            product.setPrice(Double.valueOf(this.price));
        }
        product.setImageUrl(productRequestDto.image);
        Category category1 = new Category();
        category1.setName(productRequestDto.getCategory());
        System.out.println("inside ProductRequestDto toProduct method"+category1.getName());
        product.setCategory(category1);
        return product;

    }
}
