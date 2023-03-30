package com.midwestoil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/company")
public class CompanyController {

    @GetMapping("/create")
    public String companyCreate() {
        return "administration/company/create";
    }
}
