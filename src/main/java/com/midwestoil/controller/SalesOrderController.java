package com.midwestoil.controller;

import com.midwestoil.dto.*;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        return "/salesOrder/create";
    }

    @PostMapping("/create")
    public String insertTask(SalesOrderDTO salesOrderDTO) {
        salesOrderService.save(salesOrderDTO);
        return "redirect:/salesOrder/create";
    }

    @GetMapping("/status")
    public String getAllSalesOrders(Model model) {

        model.addAttribute("salesOrders", salesOrderService.findAll());

        return "/salesOrder/status";
    }

    @GetMapping("/salesOrder/{salesOrderId}")
    @ResponseBody
    public SalesOrderDTO getSalesOrderDetails(@PathVariable("salesOrderId") Long salesOrderId) {
        // Retrieve the sales order details based on the salesOrderId
        return salesOrderService.findById(salesOrderId);
    }
}
