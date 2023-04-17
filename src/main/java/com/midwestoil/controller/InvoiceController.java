package com.midwestoil.controller;

import com.midwestoil.dto.InvoiceDTO;
import com.midwestoil.dto.InvoiceItemDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.entity.InvoiceItem;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.service.InvoiceItemService;
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
        List<InvoiceItemDTO> invoiceItems = invoiceDTO.getItems();
        model.addAttribute("invoices", invoiceDTO);
        model.addAttribute("taxes",  taxService.findTaxesForProducts(invoiceItems.stream().map(InvoiceItemDTO::getProduct).collect(Collectors.toList())));

        return "invoice/view/invoice";
    }
}
