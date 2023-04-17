package com.midwestoil.service.impl;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<TaxDTO> findAllTaxByAssignedZipCode(String zipCode) {
        return findAll().stream().filter(eachTax -> eachTax.getZipCode().equals(zipCode)).collect(Collectors.toList());
    }

    @Override
    public List<TaxDTO> findAllTaxByAssignedProduct(ProductDTO productDTO) {
        return findAll().stream().filter(eachTax -> eachTax.getProduct().equals(productDTO)).collect(Collectors.toList());
    }

    @Override
    public List<TaxDTO> findAllTaxByProductAndZipCode(ProductDTO productDTO, String zipCode) {
        return findAll().stream()
                .filter(eachTax -> eachTax.getProduct().equals(productDTO) && eachTax.getZipCode().equals(zipCode))
                .collect(Collectors.toList());
    }

    public List<TaxDTO> findTaxesForProduct(ProductDTO productDTO) {
        // Extract the zip code from the assigned company
        String zipCode = productDTO.getCompany().getZipCode();

        // Use the previously created method to find all taxes for the product within the specified zip code
        List<TaxDTO> taxes = findAllTaxByProductAndZipCode(productDTO, zipCode);

        return taxes;
    }

    public List<TaxDTO> findTaxesForProducts(List<ProductDTO> productDTOs) {
        List<TaxDTO> allTaxes = new ArrayList<>();

        for (ProductDTO productDTO : productDTOs) {
            // Extract the zip code from the assigned company
            String zipCode = productDTO.getCompany().getZipCode();

            // Use the previously created method to find all taxes for the product within the specified zip code
            List<TaxDTO> taxes = findAllTaxByProductAndZipCode(productDTO, zipCode);

            // Add the taxes for the current product to the list of all taxes
            allTaxes.addAll(taxes);
        }

        return allTaxes;
    }

}
