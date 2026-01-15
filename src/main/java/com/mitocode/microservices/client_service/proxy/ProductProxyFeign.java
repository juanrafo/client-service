package com.mitocode.microservices.client_service.proxy;

import com.mitocode.microservices.client_service.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "${client.openfeign.path}")
//@FeignClient(name = "product-service")
@FeignClient(name = "cloud-gateway")
public interface ProductProxyFeign {

    @GetMapping("/api/product-service/product")
    List<ProductDTO> getAllProducts();
}
