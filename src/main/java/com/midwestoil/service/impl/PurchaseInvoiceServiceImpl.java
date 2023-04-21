package com.midwestoil.service.impl;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.PurchaseInvoiceDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.enums.Status;
import com.midwestoil.service.PurchaseInvoiceService;
import com.midwestoil.service.SalesOrderService;
import com.midwestoil.service.TaxService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseInvoiceServiceImpl extends AbstractMapService<PurchaseInvoiceDTO, Long> implements PurchaseInvoiceService {

    SalesOrderService salesOrderService;
    TaxService taxService;

    public PurchaseInvoiceServiceImpl(SalesOrderService salesOrderService, TaxService taxService) {
        this.salesOrderService = salesOrderService;
        this.taxService = taxService;
    }

    @Override
    public PurchaseInvoiceDTO save(PurchaseInvoiceDTO object) {

        if (salesOrderService.findById(object.getSalesOrderId().getSalesOrderId()).getSalesOrderStatus() == Status.OPEN) {
            salesOrderService.findById(object.getSalesOrderId().getSalesOrderId()).setSalesOrderStatus(Status.IN_PROGRESS);
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
    public List<PurchaseInvoiceDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(PurchaseInvoiceDTO object) {
        super.update(object.getInvoiceNumber(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PurchaseInvoiceDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaxDTO> calculateTaxByProduct(Long id) {
        ProductDTO productFromInvoice = findById(id).getProduct();
        CompanyDTO companyFromInvoice = findById(id).getVendor();

        return taxService.findTaxesForProduct(productFromInvoice);
    }

    @Override
    public double calculateTotalTaxForInvoice(Long id) {
        double totalTax = 0;

        PurchaseInvoiceDTO purchaseInvoiceDTO = findById(id);
        String productZipCode = purchaseInvoiceDTO.getProduct().getCompany().getZipCode();
        ProductDTO productDTO = purchaseInvoiceDTO.getProduct();

        List<TaxDTO> taxDTOList = taxService.findTaxesForProduct(productDTO);
        for (TaxDTO eachTax : taxDTOList) {
            if(productZipCode.equals(eachTax.getZipCode())) {
                totalTax += Double.valueOf(eachTax.getTaxPrice()) * purchaseInvoiceDTO.getQuantity();

            }
        }

        purchaseInvoiceDTO.setTaxAmount(totalTax);

        return totalTax;
    }

    @Override
    public PurchaseInvoiceDTO findBySalesOrderId(Long id) {
        return super.findAll().stream().filter(eachInvoice -> eachInvoice.getSalesOrderId().getSalesOrderId() == id).findFirst().get();
    }


}
