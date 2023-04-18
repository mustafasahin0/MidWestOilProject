package com.midwestoil.dto;

import com.midwestoil.entity.Company;
import com.midwestoil.entity.Product;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalesOrderDTO {

    private Long salesOrderId;
    private Company vendor;
    private Company client;
    private Product product;
    private Double price;
    private Double quantity;
    private LocalDate orderDate;
    private Status salesOrderStatus;

}
