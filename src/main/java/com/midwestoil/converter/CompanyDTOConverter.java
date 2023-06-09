package com.midwestoil.converter;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.ProjectDTO;
import com.midwestoil.dto.RoleDTO;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CompanyDTOConverter implements Converter<String, CompanyDTO> {

    CompanyService companyService;

    //injection
    public CompanyDTOConverter(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDTO convert(String source) {
        return companyService.findById(Long.parseLong(source));
    }

}