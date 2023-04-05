package com.midwestoil.controller;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.enums.State;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


public class TaxController {

    TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    public String taxCreate(Model model) {

        model.addAttribute("tax", new TaxDTO());


        return "administration/tax/create";
    }
}
