package com.midwestoil.entity;


import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class Product extends BaseEntity{

    private Long id;
    private String name;
    private Company companyName;

}
