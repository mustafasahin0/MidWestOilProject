package com.midwestoil.controller;

import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;


public class PurchaseOrderController {

    CompanyService companyService;

    public PurchaseOrderController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String createUser(Model model) {

        model.addAttribute("vendors", companyService.findAll().stream().filter(each -> each.getCompanyType() == CompanyType.VENDOR).collect(Collectors.toList()));

        return "invoice/purchase/create";
    }
}
