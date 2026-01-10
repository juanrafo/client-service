package com.mitocode.microservices.client_service.model;


import lombok.Data;

@Data
public class ProductDTO {

    private String productId;
    private String productName;
    private String productType;
    private Long price;
    private Integer stock;
    private Integer port;

}
