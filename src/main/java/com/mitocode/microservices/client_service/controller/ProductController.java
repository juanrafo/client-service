package com.mitocode.microservices.client_service.controller;


import com.mitocode.microservices.client_service.model.ProductDTO;
import com.mitocode.microservices.client_service.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

 /*   @GetMapping("/products")
    @CircuitBreaker(name = "product-cb", fallbackMethod = "alternativeCompletableMethod")
    @TimeLimiter(name = "product-time")
    public CompletableFuture<ResponseEntity<List<ProductDTO>>> getAllProducts() {
        return CompletableFuture
                .supplyAsync(()->ResponseEntity
                        .ok(productService.getAllProducts()));
    }*/


//    @GetMapping("/products")
//    public ResponseEntity<List<ProductDTO>> getAllProducts() {
//        return circuitBreakerFactory.create("mitocode")
//                .run(() -> ResponseEntity.ok(productService.getAllProducts()),
//                        e -> alternativeMethod(e));
//    }

//    @GetMapping("/products/")
//    @CircuitBreaker(name = "product-cb", fallbackMethod = "alternativeMethod")
//    public ResponseEntity<List<ProductDTO>> getAllProducts() {
//        return ResponseEntity.ok(productService.getAllProducts());
//    }

//    @GetMapping("/products/{flag}")
//    @CircuitBreaker(name = "product-cb", fallbackMethod = "alternativeMethod")
//    public ResponseEntity<List<ProductDTO>> getAllProducts(@PathVariable("flag") boolean flag) {
//        log.info("Received request to fetch products with flag: {}", flag);
//        return ResponseEntity.ok(productService.getAllProductsWithFlag(flag));
//    }

    public ResponseEntity<List<ProductDTO>> alternativeMethod(Throwable e) {
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


    public CompletableFuture<ResponseEntity<List<ProductDTO>>> alternativeCompletableMethod(Throwable e) {
        log.error("Error Timelimiter: " + e.getMessage());
        ProductDTO productDTO = ProductDTO.builder()
                .productType("Fake")
                .productId("P99999")
                .productName("Producto Fake")
                .build();
        List<ProductDTO> products = new ArrayList<>();
        products.add(productDTO);
        return CompletableFuture.supplyAsync(()-> ResponseEntity.ok(products));
    }
}
