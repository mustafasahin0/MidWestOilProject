package com.midwestoil.service;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.enums.CompanyType;

import java.util.List;

public interface CompanyService extends CrudService<CompanyDTO, Long> {

    List<CompanyDTO> getCompaniesByType(CompanyType companyType);
}
