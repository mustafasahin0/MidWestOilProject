package com.midwestoil.service.impl;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends AbstractMapService<Long, CompanyDTO> implements CompanyService {

    @Override
    public CompanyDTO save(CompanyDTO object) {
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
    public CompanyDTO findById(Long id) {
        return super.findById(id);
    }
}