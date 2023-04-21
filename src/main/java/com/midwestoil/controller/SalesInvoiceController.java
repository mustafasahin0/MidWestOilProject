package com.midwestoil.controller;

import com.midwestoil.dto.PurchaseInvoiceDTO;
import com.midwestoil.dto.SalesInvoiceDTO;
import com.midwestoil.entity.PurchaseInvoice;
import com.midwestoil.entity.SalesInvoice;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.CompanyService;
import com.midwestoil.service.PurchaseInvoiceService;
import com.midwestoil.service.SalesInvoiceService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice/sales")
public class SalesInvoiceController {

    PurchaseInvoiceService purchaseInvoiceService;
    CompanyService companyService;
    SalesOrderService salesOrderService;
    SalesInvoiceService salesInvoiceService;

    public SalesInvoiceController(PurchaseInvoiceService purchaseInvoiceService, CompanyService companyService, SalesOrderService salesOrderService, SalesInvoiceService salesInvoiceService) {
        this.purchaseInvoiceService = purchaseInvoiceService;
        this.companyService = companyService;
        this.salesOrderService = salesOrderService;
        this.salesInvoiceService = salesInvoiceService;
    }

    @GetMapping("/create")
    public String createInvoice(Model model) {

        model.addAttribute("salesInvoice", new SalesInvoiceDTO());
        model.addAttribute("salesOrders", salesOrderService.findAll());
        model.addAttribute("salesInvoices", salesInvoiceService.findAll());

        return "/invoice/sales/create";
    }

    @PostMapping("/create")
    public String insertInvoice(SalesInvoiceDTO salesInvoiceDTO) {
        salesInvoiceService.save(salesInvoiceDTO);
        //model.addAttribute("purchaseInvoice", purchaseInvoiceService.findBySalesOrderId(salesInvoiceService.findById(salesInvoiceDTO.getInvoiceNumber()).getSalesOrderId().getSalesOrderId()));
        return "redirect:/invoice/sales/create";
    }

    @GetMapping("/status")
    public String getAllSalesOrders(Model model) {

        model.addAttribute("salesInvoices", salesInvoiceService.findAll());

        return "/invoice/sales/status";
    }

    @GetMapping("/view/{salesInvoiceId}")
    public String viewInvoice(@PathVariable("salesInvoiceId") String salesInvoiceId, Model model) {
        model.addAttribute("salesInvoice", salesInvoiceService.findById(Long.parseLong(salesInvoiceId)));
        return "/invoice/sales/view";
    }
}
