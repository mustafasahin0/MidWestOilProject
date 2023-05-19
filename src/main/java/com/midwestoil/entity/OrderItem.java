package com.midwestoil.entity;

import com.midwestoil.dto.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class OrderItem {
    private Long id;
    private ProductDTO product;
    private Double quantity;
    private Double unitPrice;

    public OrderItem(Long id, ProductDTO product, Double quantity, Double unitPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}
