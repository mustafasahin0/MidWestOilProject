package com.midwestoil.service.impl;

import com.midwestoil.dto.InvoiceDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.service.InvoiceService;
import com.midwestoil.service.impl.AbstractMapService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvoiceServiceImpl extends AbstractMapService<InvoiceDTO, Long> implements InvoiceService {

    @Override
    public InvoiceDTO save(InvoiceDTO object) {
        if(object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);
    }

    @Override
    public List<InvoiceDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(InvoiceDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public InvoiceDTO findById(Long id) {
        return super.findById(id);
    }
}
