package com.chrosciu.shop.orders;

import com.chrosciu.shop.orders.OrderDto;
import com.chrosciu.shop.orders.OrderMapper;
import com.chrosciu.shop.orders.OrderNotFoundException;
import com.chrosciu.shop.orders.OrderRepository;
import org.mapstruct.factory.Mappers;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("orders")
public class OrderRestService {
    @EJB
    private OrderRepository orderRepository;

    private final OrderMapper orderMapper = Mappers.getMapper(com.chrosciu.shop.orders.OrderMapper.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDto> getProducts() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDto getProduct(@PathParam("id") long id) {
        return Optional.ofNullable(orderRepository.findById(id))
                .map(orderMapper::toDto)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}