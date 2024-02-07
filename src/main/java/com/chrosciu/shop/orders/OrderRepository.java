package com.chrosciu.shop.orders;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    List<Order> findAll();
}