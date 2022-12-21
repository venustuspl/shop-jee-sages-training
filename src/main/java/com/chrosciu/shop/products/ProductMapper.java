package com.chrosciu.shop.products;

import java.util.Optional;
import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductOutputDto toDto(Product product);

    default String fromPrice(FastMoney price) {
        return Optional.ofNullable(price)
                .map(FastMoney::toString)
                .orElse("");
    }
}
