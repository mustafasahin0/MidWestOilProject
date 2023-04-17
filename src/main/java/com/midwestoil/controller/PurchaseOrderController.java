package com.midwestoil.controller;

import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice/purchase")
public class PurchaseOrderController {

    CompanyService companyService;
    ProductService productService;

    public PurchaseOrderController(CompanyService companyService, ProductService productService) {
        this.companyService = companyService;
        this.productService = productService;
    }

    @GetMapping("/create")
    public String createInvoice(Model model) {

        model.addAttribute("vendors", companyService.findAll().stream().filter(each -> each.getCompanyType() == CompanyType.VENDOR).collect(Collectors.toList()));
        model.addAttribute("products", productService.findAll());

        return "invoice/purchase/create";
    }
}
