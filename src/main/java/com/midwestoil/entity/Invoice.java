package com.midwestoil.entity;

import com.midwestoil.enums.InvoiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class Invoice {

    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private Company company;
    private InvoiceType invoiceType;
    private List<InvoiceItem> items;


    public Invoice(Long id, String invoiceNumber, LocalDate invoiceDate, Company company, InvoiceType invoiceType, List<InvoiceItem> items) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.company = company;
        this.invoiceType = invoiceType;
        this.items = items;
    }
}
