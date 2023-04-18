package com.midwestoil.controller;

import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salesOrder")
public class SalesOrderController {

    private final SalesOrderService salesOrderService;
    private final CompanyService companyService;
    private final ProductService productService;

    public SalesOrderController(SalesOrderService salesOrderService, CompanyService companyService, ProductService productService) {
        this.salesOrderService = salesOrderService;
        this.companyService = companyService;
        this.productService = productService;
    }


    @GetMapping("/create")
    public String createSalesOrder(Model model) {

        model.addAttribute("salesOrder", new SalesOrderDTO());
        model.addAttribute("clients", companyService.getCompaniesByType(CompanyType.CLIENT));
        model.addAttribute("vendors", companyService.getCompaniesByType(CompanyType.VENDOR));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("salesOrders", salesOrderService.findAll());


        return "salesOrder/create";
    }
}
