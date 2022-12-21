package com.chrosciu.shop.products;

public class ProductInitializer {
    private ProductRepository productRepository = new HashMapProductRepository();

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

    public void init() {
        productRepository.save(VIDEO_PRODUCT);
        productRepository.save(BOOK_PRODUCT);
    }

    public static void main(String[] args) {
        new ProductInitializer().init();
        System.out.println("Products initialized!");
    }
}
