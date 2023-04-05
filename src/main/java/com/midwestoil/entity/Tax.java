package com.midwestoil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class Tax {

    private Long id;
    private String name;
    private BigDecimal taxPrice;

    public Tax(Long id, String name, BigDecimal taxPrice) {
        this.id = id;
        this.name = name;
        this.taxPrice = taxPrice;
    }
}
