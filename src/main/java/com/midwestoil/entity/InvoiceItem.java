package com.midwestoil.entity;

import com.midwestoil.dto.TaxDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InvoiceItem {

    private Long id;
    private Product product;
    private Integer quantity;
    private Double price;
    private TaxDTO taxDTO;


    public InvoiceItem(Long id, Product product, Integer quantity, Double price, TaxDTO taxDTO) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxDTO = taxDTO;
    }
}
