package com.chrosciu.shop.orders;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class HashMapOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private Map<Long, Order> orders = new HashMap<>();
    private long index = 0;

    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findAll() {
        return List.copyOf(orders.values());
    }
}
