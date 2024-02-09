package com.chrosciu.shop.orders;

import com.chrosciu.shop.products.Product;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private List<Product> products;
}
