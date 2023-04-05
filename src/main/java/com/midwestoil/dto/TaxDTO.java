package com.midwestoil.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaxDTO {

    private Long id;
    private String name;
    private BigDecimal taxPrice;
}
