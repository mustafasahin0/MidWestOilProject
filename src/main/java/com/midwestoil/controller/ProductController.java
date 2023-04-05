package com.midwestoil.controller;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.State;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;


public class ProductController {

    CompanyService companyService;
    ProductService productService;

    public ProductController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String createProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("vendors", companyService.findAll().stream().filter(each -> each.getCompanyType() == CompanyType.VENDOR).collect(Collectors.toList()));

        return "administration/product/create";
    }

    public String saveProduct(ProductDTO productDTO) {

        productService.save(productDTO);

        return "redirect:/administration/product/create";

    }
}
