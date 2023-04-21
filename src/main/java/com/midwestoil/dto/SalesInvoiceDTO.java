package com.midwestoil.dto;

import com.midwestoil.entity.Company;
import com.midwestoil.entity.PurchaseInvoice;
import com.midwestoil.entity.SalesOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class SalesInvoiceDTO {

    private Long invoiceNumber;
    private SalesOrderDTO salesOrderId;
    private PurchaseInvoiceDTO purchaseInvoice;
    private LocalDate invoiceDate;
}
