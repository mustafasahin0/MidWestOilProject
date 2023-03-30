package com.midwestoil.entity;

import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Company extends BaseEntity{

    private Long id;
    private String name;
    private String phone;
    private String email;
    private State state;
    private String zipCode;
    private CompanyType companyType;
}
