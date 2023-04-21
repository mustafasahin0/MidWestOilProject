package com.midwestoil.converter;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class SalesOrderDTOConverter implements Converter<String, SalesOrderDTO> {

    SalesOrderService salesOrderService;

    //injection
    public SalesOrderDTOConverter(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @Override
    public SalesOrderDTO convert(String source) {
        return salesOrderService.findById(Long.parseLong(source));
    }

}