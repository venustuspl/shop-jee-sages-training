package com.chrosciu.shop.orders;


import com.chrosciu.shop.products.Product;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<Product> products;

    public <E> Order(List<E> savedVideo) {
    }

    public BigDecimal getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
