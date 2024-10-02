package com.scaler.productService.dtos;

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
}
