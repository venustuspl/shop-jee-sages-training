package com.chrosciu.shop.orders;

import com.chrosciu.shop.products.Product;
import com.chrosciu.shop.products.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    OrderDto toDto(Order order);
}
