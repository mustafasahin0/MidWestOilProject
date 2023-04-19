package com.midwestoil.controller;

import com.midwestoil.dto.InvoiceDTO;
import com.midwestoil.dto.InvoiceItemDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice/purchase")
public class PurchaseOrderController {

    CompanyService companyService;
    ProductService productService;
    SalesOrderService salesOrderService;

    public PurchaseOrderController(CompanyService companyService, ProductService productService, SalesOrderService salesOrderService) {
        this.companyService = companyService;
        this.productService = productService;
        this.salesOrderService = salesOrderService;
    }

    @GetMapping("/create")
    public String createInvoice(Model model) {

        model.addAttribute("purchaseOrder", new InvoiceDTO());
        model.addAttribute("vendors", companyService.findAll().stream().filter(each -> each.getCompanyType() == CompanyType.VENDOR).collect(Collectors.toList()));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("salesOrders", salesOrderService.findAll());
        return "invoice/purchase/create";
    }
}
