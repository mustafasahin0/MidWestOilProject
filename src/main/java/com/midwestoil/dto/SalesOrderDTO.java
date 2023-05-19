package com.midwestoil.dto;

import com.midwestoil.entity.Company;
import com.midwestoil.entity.Product;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalesOrderDTO {

    private Long salesOrderId;
    private CompanyDTO vendor;
    private CompanyDTO client;
    private List<OrderItemDTO> orderItems;
    private LocalDate orderDate;
    private Status salesOrderStatus;

}
