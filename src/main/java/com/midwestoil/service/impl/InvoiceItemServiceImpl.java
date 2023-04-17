package com.midwestoil.service.impl;

import com.midwestoil.dto.InvoiceDTO;
import com.midwestoil.dto.InvoiceItemDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.service.InvoiceItemService;
import com.midwestoil.service.InvoiceService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InvoiceItemServiceImpl extends AbstractMapService<InvoiceItemDTO, Long> implements InvoiceItemService {

    TaxService taxService;

    public InvoiceItemServiceImpl(TaxService taxService) {
        this.taxService = taxService;
    }

    @Override
    public InvoiceItemDTO save(InvoiceItemDTO object) {
        if(object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        // Call the findTaxesForProduct method
        List<TaxDTO> taxes = taxService.findTaxesForProduct(object.getProduct());

        // Set the quantity for each tax in the list using the quantity field from the InvoiceItemDTO object
        List<TaxDTO> updatedTaxes = taxes.stream()
                .peek(tax -> tax.setQuantity(object.getQuantity().toString()))
                .toList();

        // Perform any necessary operations on the updated taxes list if needed
        // ...

        return super.save(object.getId(), object);
    }

    @Override
    public List<InvoiceItemDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(InvoiceItemDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public InvoiceItemDTO findById(Long id) {
        return super.findById(id);
    }
}
