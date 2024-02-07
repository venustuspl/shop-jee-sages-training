package com.chrosciu.shop.orders;


import com.chrosciu.shop.products.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Serializable {
    private Long id;
    @NonNull
    private List<Product> products;

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
