package com.midwestoil.service;

import com.midwestoil.dto.*;
import com.midwestoil.enums.Status;

import java.util.List;

public interface PurchaseInvoiceService extends CrudService<PurchaseInvoiceDTO, Long> {

    List<TaxDTO> calculateTaxByProduct(Long id);

    double calculateTotalTaxForInvoice(Long id);

    PurchaseInvoiceDTO findBySalesOrderId(Long id);

}
