package com.midwestoil.controller;

import com.midwestoil.dto.PurchaseInvoiceDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.ProductService;
import com.midwestoil.service.PurchaseInvoiceService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice/purchase")
public class PurchaseInvoiceController {

    CompanyService companyService;
    ProductService productService;
    SalesOrderService salesOrderService;
    PurchaseInvoiceService purchaseInvoiceService;

    public PurchaseInvoiceController(CompanyService companyService, ProductService productService, SalesOrderService salesOrderService, PurchaseInvoiceService purchaseInvoiceService) {
        this.companyService = companyService;
        this.productService = productService;
        this.salesOrderService = salesOrderService;
        this.purchaseInvoiceService = purchaseInvoiceService;
    }

    @GetMapping("/create")
    public String createInvoice(Model model) {

        model.addAttribute("purchaseInvoice", new PurchaseInvoiceDTO());
        model.addAttribute("vendors", companyService.findAll().stream().filter(each -> each.getCompanyType() == CompanyType.VENDOR).collect(Collectors.toList()));
        model.addAttribute("products", productService.findAll());
        model.addAttribute("salesOrders", salesOrderService.findAll());
        model.addAttribute("purchaseInvoices", purchaseInvoiceService.findAll());
        return "/invoice/purchase/create";
    }

    @PostMapping("/create")
    public String insertTask(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        purchaseInvoiceService.save(purchaseInvoiceDTO);
        purchaseInvoiceService.calculateTotalTaxForInvoice(purchaseInvoiceDTO.getInvoiceNumber());
        return "redirect:/invoice/purchase/create";
    }

    @GetMapping("/status")
    public String getAllSalesOrders(Model model) {

//        double totalTax = purchaseInvoiceService.calculateTotalTaxForInvoice(purchaseInvoiceService.findAll().get(0).getInvoiceNumber());
        model.addAttribute("purchaseInvoices", purchaseInvoiceService.findAll());

        return "/invoice/purchase/status";
    }
}
