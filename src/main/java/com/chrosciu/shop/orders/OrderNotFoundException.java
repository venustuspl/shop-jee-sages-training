package com.chrosciu.shop.orders;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super(String.format("Order with id %d not found", id));
    }
}
