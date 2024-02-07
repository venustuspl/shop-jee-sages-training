package com.chrosciu.shop.products;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
public class Product implements Serializable {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductType type;
}
