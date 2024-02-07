package com.chrosciu.shop.products;

import com.chrosciu.shop.common.ExceptionDto;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException> {

    @Override
    public Response toResponse(ProductNotFoundException e) {
        return Response.status(Status.BAD_REQUEST)
                .entity(new ExceptionDto(e.getMessage()))
                .build();
    }
}
