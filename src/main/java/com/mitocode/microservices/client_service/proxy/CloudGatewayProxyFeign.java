package com.mitocode.microservices.client_service.proxy;

import com.mitocode.microservices.client_service.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cloud-gateway")
public interface CloudGatewayProxyFeign {

    @GetMapping("/api/product-service/product")
    List<ProductDTO> getAllProducts();

    @GetMapping("/api/product-service/product/{flag}")
    List<ProductDTO> getAllProductsWithFlag(@PathVariable("flag") boolean flag);

    @GetMapping("/api/product-service/product/parameter")
    List<ProductDTO> getAllProductsWithFlag(@RequestParam("tokens") String flag);

}
