package com.midwestoil.controller;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/company")
public class CompanyController {

    @GetMapping("/create")
    public String companyCreate(Model model) {

        model.addAttribute("company", new CompanyDTO());

        return "administration/company/create";
    }
}
