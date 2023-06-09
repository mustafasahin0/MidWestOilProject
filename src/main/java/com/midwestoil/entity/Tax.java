package com.midwestoil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Data
public class Tax {

    private Long id;
    private Product product;
    private String  zipCode;
    private String name;
    private String taxPrice;

    public Tax(Long id, Product product, String zipCode, String name, String taxPrice) {
        this.id = id;
        this.product = product;
        this.zipCode = zipCode;
        this.name = name;
        this.taxPrice = taxPrice;
    }
}
