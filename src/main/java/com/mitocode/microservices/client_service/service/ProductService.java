package com.mitocode.microservices.client_service.service;

import com.mitocode.microservices.client_service.model.ProductDTO;
import com.mitocode.microservices.client_service.proxy.CloudGatewayProxyFeign;
import com.mitocode.microservices.client_service.proxy.ProductProxyFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    //private final ProductProxy productProxy;
    //private final ProductProxyFeign productProxy;
    private final CloudGatewayProxyFeign productProxy;

    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return productProxy.getAllProducts();
    }

    public List<ProductDTO> getAllProductsWithFlag(boolean flag) {
        log.info("Fetching all products from Product Service");
        return productProxy.getAllProductsWithFlag(flag);
    }

}
