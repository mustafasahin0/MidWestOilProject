package com.midwestoil.dto;

import com.midwestoil.enums.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceDTO {

    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private SalesOrderDTO salesOrderId;
    private CompanyDTO company;
    private InvoiceType invoiceType;
}
