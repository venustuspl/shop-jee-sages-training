package com.chrosciu.shop.products;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javamoney.moneta.FastMoney;

@Path("products")
public class ProductRestService {
    @EJB
    private ProductRepository productRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductOutputDto> getProducts() {
        return productRepository.findAll().stream()
            .map(this::toOutputDto)
            .collect(Collectors.toList());
    }

    private ProductOutputDto toOutputDto(Product product) {
        ProductOutputDto productOutputDto = new ProductOutputDto();
        productOutputDto.setId(product.getId());
        productOutputDto.setName(product.getName());
        productOutputDto.setDescription(product.getDescription());
        productOutputDto.setPrice(
            Optional.ofNullable(product.getPrice())
                .map(FastMoney::toString)
                .orElse("")
        );
        productOutputDto.setType(product.getType());
        return productOutputDto;
    }

}
