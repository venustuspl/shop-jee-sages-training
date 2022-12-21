package com.chrosciu.shop.products;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lombok.extern.jbosslog.JBossLog;

@Singleton
@Startup
@JBossLog
public class ProductInitializer {
    @EJB
    private ProductRepository productRepository;

    private static final Product VIDEO_PRODUCT = Product.builder()
        .name("Spring masterclass")
        .description("Praktyczny kurs Spring framework")
        .type(ProductType.VIDEO)
        .price(PolishMoney.of(1500))
        .build();

    private static final Product BOOK_PRODUCT = Product.builder()
        .name("Spring guide")
        .description("Praktyczne ćwiczenia do samodzielnego wykonania")
        .type(ProductType.BOOK)
        .price(PolishMoney.of(200))
        .build();

    @PostConstruct
    public void init() {
        log.info("Initializing products");
        productRepository.save(VIDEO_PRODUCT);
        productRepository.save(BOOK_PRODUCT);
        log.info("Products initialized!");

        List<Product> productsExceptBooks = productRepository.findAllExceptType(ProductType.BOOK);
        log.info(String.format("productsExceptBooks : %s", productsExceptBooks));

        List<Product> cheapProducts = productRepository.findAllCheaperThan(10000);
        log.info(String.format("cheapProducts : %s", cheapProducts));
    }
}
