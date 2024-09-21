package com.scaler.productService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    //telling spring when it starts create an object for this class and store in application context
    //i.e injecting custom object into the spring context
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
