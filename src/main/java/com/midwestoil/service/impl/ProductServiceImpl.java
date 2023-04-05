package com.midwestoil.service.impl;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends AbstractMapService<ProductDTO, Long> implements ProductService {

    @Override
    public ProductDTO save(ProductDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public List<ProductDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProductDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public ProductDTO findById(Long id) {
        return super.findById(id);
    }
}
