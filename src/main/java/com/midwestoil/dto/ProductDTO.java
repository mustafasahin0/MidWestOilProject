package com.midwestoil.dto;
import com.midwestoil.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String companyName;

}
