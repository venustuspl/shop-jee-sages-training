package com.chrosciu.shop.orders;

import com.chrosciu.shop.common.ExceptionDto;
import com.chrosciu.shop.products.ProductNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OrderNotFoundExceptionMapper implements ExceptionMapper<OrderNotFoundException> {

    @Override
    public Response toResponse(OrderNotFoundException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionDto(e.getMessage()))
                .build();
    }
}

