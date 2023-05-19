package com.midwestoil.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderItemDTO {
    private Long id;
    private ProductDTO product;
    private Double quantity;
    private Double unitPrice;

    public OrderItemDTO(Long id, ProductDTO product, Double quantity, Double unitPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
