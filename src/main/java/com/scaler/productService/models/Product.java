package com.scaler.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

}
