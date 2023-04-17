package com.midwestoil.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private CompanyDTO company;

    public ProductDTO(Long id, String name, CompanyDTO company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }
}
