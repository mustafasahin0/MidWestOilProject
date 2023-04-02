package com.midwestoil.controller;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.State;
import com.midwestoil.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/company")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/create")
    public String companyCreate(Model model) {

        model.addAttribute("company", new CompanyDTO());
        model.addAttribute("states", State.values());
        model.addAttribute("companies", companyService.findAll());
        return "administration/company/create";
    }

    @PostMapping("/create")
    public String insertUser(CompanyDTO companyDTO, Model model) {
        companyService.save(companyDTO);
        return "redirect:/administration/company/create";
    }
}
