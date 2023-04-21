package com.midwestoil.service.impl;

import com.midwestoil.dto.PurchaseInvoiceDTO;
import com.midwestoil.dto.SalesInvoiceDTO;
import com.midwestoil.enums.Status;
import com.midwestoil.service.PurchaseInvoiceService;
import com.midwestoil.service.SalesInvoiceService;
import com.midwestoil.service.SalesOrderService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class SalesInvoiceServiceImpl extends AbstractMapService<SalesInvoiceDTO, Long> implements SalesInvoiceService {

    SalesOrderService salesOrderService;
    PurchaseInvoiceService purchaseInvoiceService;

    public SalesInvoiceServiceImpl(SalesOrderService salesOrderService, PurchaseInvoiceService purchaseInvoiceService) {
        this.salesOrderService = salesOrderService;
        this.purchaseInvoiceService = purchaseInvoiceService;
    }

    @Override
    public SalesInvoiceDTO save(SalesInvoiceDTO object) {

        if (salesOrderService.findById(object.getSalesOrderId().getSalesOrderId()).getSalesOrderStatus() == Status.IN_PROGRESS) {
            salesOrderService.findById(object.getSalesOrderId().getSalesOrderId()).setSalesOrderStatus(Status.COMPLETE);
        }

        if(object.getPurchaseInvoice() == null) {
            object.setPurchaseInvoice(purchaseInvoiceService.findBySalesOrderId(object.getSalesOrderId().getSalesOrderId()));
        }

        if (object.getInvoiceDate() == null) {
            object.setInvoiceDate(LocalDate.now());
        }

        if (object.getInvoiceNumber() == null) {
            long mostSignificantBits = Math.abs(UUID.randomUUID().getMostSignificantBits() % 900000) + 100000;
            object.setInvoiceNumber(mostSignificantBits);
        }



        return super.save(object.getInvoiceNumber(), object);
    }

    @Override
    public List<SalesInvoiceDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(SalesInvoiceDTO object) {
        super.update(object.getInvoiceNumber(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public SalesInvoiceDTO findById(Long id) {
        return super.findById(id);
    }
}
