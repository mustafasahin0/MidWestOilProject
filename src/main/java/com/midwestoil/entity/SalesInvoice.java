package com.midwestoil.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class SalesInvoice extends BaseEntity {

    private Long invoiceNumber;
    private SalesOrder salesOrderId;
    private PurchaseInvoice purchaseInvoice;
    private LocalDate invoiceDate;

    public SalesInvoice(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long invoiceNumber, SalesOrder salesOrderId, PurchaseInvoice purchaseInvoice, LocalDate invoiceDate) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.invoiceNumber = invoiceNumber;
        this.salesOrderId = salesOrderId;
        this.purchaseInvoice = purchaseInvoice;
        this.invoiceDate = invoiceDate;
    }
}
