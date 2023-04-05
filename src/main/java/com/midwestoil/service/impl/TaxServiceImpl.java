package com.midwestoil.service.impl;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxServiceImpl extends AbstractMapService<TaxDTO, Long> implements TaxService {

    @Override
    public TaxDTO save(TaxDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<TaxDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaxDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaxDTO findById(Long id) {
        return super.findById(id);
    }
}
