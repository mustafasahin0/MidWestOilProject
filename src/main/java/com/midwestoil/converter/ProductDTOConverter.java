package com.midwestoil.converter;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProductService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProductDTOConverter implements Converter<String, ProductDTO> {

    ProductService productService;

    //injection
    public ProductDTOConverter(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO convert(String source) {
        return productService.findById(Long.parseLong(source));
    }

}