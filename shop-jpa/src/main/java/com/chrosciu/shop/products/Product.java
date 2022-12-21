package com.chrosciu.shop.products;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.javamoney.moneta.FastMoney;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
@ToString
@NamedQuery(
    name = Product.FIND_ALL_EXCEPT_TYPE,
    query = "select p from Product p where p.type <> :productType"
)
public class Product implements Serializable {
    public static final String FIND_ALL_EXCEPT_TYPE = "Product.findAllExceptType";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private FastMoney price;
    private ProductType type;
}
