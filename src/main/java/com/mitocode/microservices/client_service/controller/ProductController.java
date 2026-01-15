package com.mitocode.microservices.client_service.controller;


import com.mitocode.microservices.client_service.model.ProductDTO;
import com.mitocode.microservices.client_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return circuitBreakerFactory.create("mitocode")
                        .run(() -> ResponseEntity.ok(productService.getAllProducts()),
                        e -> alternativeMethod(e));
    }

    private ResponseEntity<List<ProductDTO>> alternativeMethod(Throwable e) {
        log.error("Error: " + e.getMessage());
        ProductDTO productDTO = ProductDTO.builder()
                .productType("Fake")
                .productId("P99999")
                .productName("Producto Fake")
                .build();
        List<ProductDTO> products = new ArrayList<>();
        products.add(productDTO);
        return ResponseEntity.ok(products);
    }
}
