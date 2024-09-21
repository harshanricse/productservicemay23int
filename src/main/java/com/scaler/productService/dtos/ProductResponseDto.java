package com.scaler.productService.dtos;

import com.scaler.productService.models.Category;
import com.scaler.productService.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public ProductResponseDto fromProduct(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setId(product.getId());
        productResponseDto.setPrice((product.getPrice()));
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setCategoryName(product.getCategory().getName());
        return productResponseDto;
    }

}
