package com.scaler.productService.services;

import com.scaler.productService.dtos.FakeStoreProductResponseDto;
import com.scaler.productService.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductById(Long id) {
        //RestTemplate is used to make an external api call
        FakeStoreProductResponseDto responseDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductResponseDto.class);
        return responseDto.toProduct();
    }
}
