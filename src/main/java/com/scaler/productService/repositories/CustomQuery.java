package com.scaler.productService.repositories;

public class CustomQuery {
    public static final String GET_PRODUCTS_FROM_CATEGORY = "select p.id, p.title, p.description, p.category_id, p.created_at, p.updated_at, p.is_deleted, p.image_url, p.price from product p join category c on p.category_id=c.id and c.name= :categoryName";
}
