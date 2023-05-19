package com.midwestoil.controller;

import com.midwestoil.dto.InvoiceDTO;
import com.midwestoil.service.InvoiceService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice/view")
public class InvoiceController {

    InvoiceService invoiceService;
    TaxService taxService;

    public InvoiceController(InvoiceService invoiceService, TaxService taxService) {
        this.invoiceService = invoiceService;
        this.taxService = taxService;
    }

    @GetMapping("/invoice")
    public String createInvoice(Model model) {
        InvoiceDTO invoiceDTO = invoiceService.findAll().get(0);
        model.addAttribute("invoices", invoiceDTO);

        return "invoice/view/invoice";
    }
}
