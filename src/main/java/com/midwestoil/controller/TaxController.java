package com.midwestoil.controller;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.enums.State;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/tax")
public class TaxController {

    TaxService taxService;
    ProductService productService;

    public TaxController(TaxService taxService, ProductService productService) {
        this.taxService = taxService;
        this.productService = productService;
    }

    @GetMapping("/create")
    public String taxCreate(Model model) {

        model.addAttribute("tax", new TaxDTO());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("taxes", taxService.findAll());


        return "administration/tax/create";
    }

    @PostMapping("/create")
    public String insertTax(TaxDTO tax) {
        taxService.save(tax);
        return "redirect:/administration/tax/create";
    }
}
