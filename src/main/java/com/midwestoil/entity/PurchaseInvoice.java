package com.midwestoil.entity;

import com.midwestoil.dto.TaxDTO;
import com.midwestoil.enums.InvoiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class PurchaseInvoice extends BaseEntity{

    private Long invoiceNumber;
    private SalesOrder salesOrderId;
    private LocalDate invoiceDate;
    private Company vendor;
    private Product product;
    private Integer quantity;
    private Double price;
    private Double taxAmount;

    public PurchaseInvoice(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long invoiceNumber, SalesOrder salesOrderId, LocalDate invoiceDate, Company vendor, Product product, Integer quantity, Double price) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.invoiceNumber = invoiceNumber;
        this.salesOrderId = salesOrderId;
        this.invoiceDate = invoiceDate;
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public PurchaseInvoice(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long invoiceNumber, SalesOrder salesOrderId, LocalDate invoiceDate, Company vendor, Product product, Integer quantity, Double price, Double taxAmount) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.invoiceNumber = invoiceNumber;
        this.salesOrderId = salesOrderId;
        this.invoiceDate = invoiceDate;
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
    }
}
