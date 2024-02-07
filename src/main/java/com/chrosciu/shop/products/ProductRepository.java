package com.chrosciu.shop.products;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
