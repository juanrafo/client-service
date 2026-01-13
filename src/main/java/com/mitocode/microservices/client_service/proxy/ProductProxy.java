package com.mitocode.microservices.client_service.proxy;


import com.mitocode.microservices.client_service.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductProxy implements IProductService{

    private final RestTemplate restTemplate;

    @Value("${client.service.url}")
    private String baseUrl;

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of(Objects
                .requireNonNull(restTemplate.getForObject(baseUrl, ProductDTO[].class)));
    }

}
