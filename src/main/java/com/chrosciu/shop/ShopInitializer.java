package com.chrosciu.shop;


import com.chrosciu.shop.orders.Order;
import com.chrosciu.shop.orders.OrderRepository;
import com.chrosciu.shop.products.Product;
import com.chrosciu.shop.products.ProductRepository;
import com.chrosciu.shop.products.ProductType;
import lombok.extern.jbosslog.JBossLog;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;
import java.util.List;

@Singleton
@Startup
@JBossLog
public class ShopInitializer {
    @EJB
    private ProductRepository productRepository;
    @EJB
    private OrderRepository orderRepository;

    private static final Product VIDEO_PRODUCT = Product.builder()
        .name("Spring masterclass")
        .description("Praktyczny kurs Spring framework")
        .type(ProductType.VIDEO)
        .price(BigDecimal.valueOf(1500))
        .build();

    private static final Product BOOK_PRODUCT = Product.builder()
        .name("Spring guide")
        .description("Praktyczne ćwiczenia do samodzielnego wykonania")
        .type(ProductType.BOOK)
        .price(BigDecimal.valueOf(200))
        .build();

    @PostConstruct
    public void init() {
        log.info("Initializing shop");

        Product savedVideo = productRepository.save(VIDEO_PRODUCT);
        Product savedBook = productRepository.save(BOOK_PRODUCT);

        Order order = new Order(List.of(savedVideo, savedBook));
        orderRepository.save(order);
        Order order1 = new Order(List.of(savedVideo));
        orderRepository.save(order);
        Order order2 = new Order();
        orderRepository.save(order);

        log.info("Shop initialized");

        List<Product> productsExceptBooks = productRepository.findAllExceptType(ProductType.BOOK);
        log.info(String.format("productsExceptBooks : %s", productsExceptBooks));
    }
}
