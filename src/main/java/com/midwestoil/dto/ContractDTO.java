package com.midwestoil.dto;

import com.midwestoil.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractDTO {

    private Long contractId;
    private CompanyDTO client;
    private Double percentage;
}
