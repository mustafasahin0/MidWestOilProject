package com.midwestoil.service.impl;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl extends AbstractMapService<CompanyDTO, Long> implements CompanyService {

    @Override
    public CompanyDTO save(CompanyDTO object) {

        if(object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);
    }

    @Override
    public List<CompanyDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(CompanyDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public CompanyDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<CompanyDTO> getCompaniesByType(CompanyType companyType) {
        return findAll().stream().filter(each -> each.getCompanyType() == companyType).collect(Collectors.toList());
    }
}
