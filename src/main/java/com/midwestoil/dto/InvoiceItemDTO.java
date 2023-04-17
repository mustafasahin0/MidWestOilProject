package com.midwestoil.dto;

import com.midwestoil.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceItemDTO {

    private Long id;
    private ProductDTO product;
    private Integer quantity;
    private Double price;
    private TaxDTO taxDTO;
}
