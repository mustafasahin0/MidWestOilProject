package com.midwestoil.service;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.TaxDTO;

import java.util.List;

public interface TaxService extends CrudService<TaxDTO, Long>{

    List<TaxDTO> findAllTaxByAssignedZipCode(String zipCode);
    List<TaxDTO> findAllTaxByAssignedProduct(ProductDTO productDTO);

    List<TaxDTO> findAllTaxByProductAndZipCode(ProductDTO productDTO, String zipCode);

    List<TaxDTO> findTaxesForProduct(ProductDTO productDTO);

    List<TaxDTO> findTaxesForProducts(List<ProductDTO> productDTOList);

}
