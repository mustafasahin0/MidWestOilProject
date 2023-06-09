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

@Controller
@RequestMapping("/administration/product")
public class ProductController {

    CompanyService companyService;
    ProductService productService;

    public ProductController(CompanyService companyService, ProductService productService) {
        this.companyService = companyService;
        this.productService = productService;
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("vendors", companyService.getCompaniesByType(CompanyType.VENDOR));
        model.addAttribute("products", productService.findAll());

        return "administration/product/create";
    }

    @PostMapping("/create")
    public String saveProduct(ProductDTO productDTO) {

        productService.save(productDTO);

        return "redirect:/administration/product/create";

    }
}
