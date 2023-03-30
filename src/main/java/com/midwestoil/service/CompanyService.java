package com.midwestoil.service;

import com.midwestoil.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO save(CompanyDTO companyDTO);

    CompanyDTO findById(Long id);

    List<CompanyDTO> findAll();

    void delete(CompanyDTO companyDTO);

    void deleteById(Long id);
}
