package com.mitocode.microservices.client_service.proxy;

import com.mitocode.microservices.client_service.model.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "${client.openfeign.path}")
public interface ProductProxyFeign {

    @GetMapping("/product")
    List<ProductDTO> getAllProducts();
}
