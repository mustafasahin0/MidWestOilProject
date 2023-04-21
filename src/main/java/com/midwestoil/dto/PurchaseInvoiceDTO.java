package com.midwestoil.dto;

import com.midwestoil.entity.Company;
import com.midwestoil.entity.Product;
import com.midwestoil.entity.SalesOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class PurchaseInvoiceDTO {

    private Long invoiceNumber;
    private SalesOrderDTO salesOrderId;
    private LocalDate invoiceDate;
    private CompanyDTO vendor;
    private ProductDTO product;
    private Integer quantity;
    private Double price;
    private Double taxAmount;

    public PurchaseInvoiceDTO(Long invoiceNumber, SalesOrderDTO salesOrderId, LocalDate invoiceDate, CompanyDTO vendor, ProductDTO product, Integer quantity, Double price, Double taxAmount) {
        this.invoiceNumber = invoiceNumber;
        this.salesOrderId = salesOrderId;
        this.invoiceDate = invoiceDate;
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
    }

    public PurchaseInvoiceDTO(Long invoiceNumber, SalesOrderDTO salesOrderId, LocalDate invoiceDate, CompanyDTO vendor, ProductDTO product, Integer quantity, Double price) {
        this.invoiceNumber = invoiceNumber;
        this.salesOrderId = salesOrderId;
        this.invoiceDate = invoiceDate;
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
