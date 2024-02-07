package com.chrosciu.shop.products;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Product findById(long id);
}
