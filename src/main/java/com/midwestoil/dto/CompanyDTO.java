package com.midwestoil.dto;

import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private State state;
    private String zipCode;
    private CompanyType companyType;
}
