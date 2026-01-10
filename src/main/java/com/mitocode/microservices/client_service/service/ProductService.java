package com.mitocode.microservices.client_service.service;

import com.mitocode.microservices.client_service.model.ProductDTO;
import com.mitocode.microservices.client_service.proxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductProxy productProxy;

    public List<ProductDTO> getAllProducts() {
        return productProxy.getAllProducts();
    }


}
