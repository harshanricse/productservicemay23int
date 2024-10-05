package com.scaler.productService.services;

import com.scaler.productService.ProductNotFoundException;
import com.scaler.productService.dtos.FakeStoreProductResponseDto;
import com.scaler.productService.dtos.ProductRequestDto;
import com.scaler.productService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreservice")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        //RestTemplate is used to make an external api call
        FakeStoreProductResponseDto responseDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductResponseDto.class);
        if(responseDto == null){
            throw new ProductNotFoundException("Product with id: "+id+" not found ");
        }
        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductResponseDto[] responseDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductResponseDto[].class);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < responseDtos.length; i++) {
            products.add(responseDtos[i].toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, Double price, String description, String image, String category) {
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setTitle(title);
        requestDto.setPrice(price);
        requestDto.setDescription(description);
        requestDto.setImage(image);
        requestDto.setCategory(category);
        FakeStoreProductResponseDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", requestDto, FakeStoreProductResponseDto.class);
        return responseDto.toProduct();
    }

    @Override
    public Product partialUpdateById(Long id,Product product) {
        return null;
    }
}
