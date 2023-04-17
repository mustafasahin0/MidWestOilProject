package com.midwestoil.dto;

import com.midwestoil.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class TaxDTO {

    private Long id;
    private ProductDTO product;
    private String  zipCode;
    private String name;
    private String taxPrice;
    private String quantity;

    public TaxDTO(Long id, ProductDTO product, String zipCode, String name, String taxPrice) {
        this.id = id;
        this.product = product;
        this.zipCode = zipCode;
        this.name = name;
        this.taxPrice = taxPrice;
    }

    public TaxDTO(Long id, ProductDTO product, String zipCode, String name, String taxPrice, String quantity) {
        this.id = id;
        this.product = product;
        this.zipCode = zipCode;
        this.name = name;
        this.taxPrice = taxPrice;
        this.quantity = quantity;
    }
}
