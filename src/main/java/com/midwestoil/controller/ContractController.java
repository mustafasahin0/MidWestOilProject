package com.midwestoil.controller;

import com.midwestoil.dto.ContractDTO;
import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ContractService;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/contract")
public class ContractController {

    private ContractService contractService;
    private CompanyService companyService;

    public ContractController(ContractService contractService, CompanyService companyService) {
        this.contractService = contractService;
        this.companyService = companyService;
    }

    @GetMapping("/create")
    public String createContract(Model model) {

        model.addAttribute("contract", new ContractDTO());
        model.addAttribute("clients", companyService.getCompaniesByType(CompanyType.CLIENT));
        model.addAttribute("contracts", contractService.findAll());

        return "/administration/contract/create";
    }

    @PostMapping("/create")
    public String insertContract(ContractDTO contractDTO) {
        contractService.save(contractDTO);
        return "redirect:/administration/contract/create";
    }
}
