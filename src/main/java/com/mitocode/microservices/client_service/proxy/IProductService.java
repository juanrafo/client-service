package com.mitocode.microservices.client_service.proxy;

import com.mitocode.microservices.client_service.model.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts();
}
