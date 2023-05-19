package com.midwestoil.entity;

import com.midwestoil.dto.OrderItemDTO;
import com.midwestoil.dto.ProductDTO;
import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class SalesOrder extends BaseEntity{

    private Long salesOrderId;
    private Company vendor;
    private Company client;
    private List<OrderItemDTO> orderItems;
    private Double price;
    private Double quantity;
    private LocalDate orderDate;
    private Status salesOrderStatus;

    public SalesOrder(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long salesOrderId, Company vendor, Company client, List<OrderItemDTO> orderItems, Double price, Double quantity, LocalDate orderDate, Status salesOrderStatus) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.salesOrderId = salesOrderId;
        this.vendor = vendor;
        this.client = client;
        this.orderItems = orderItems;
        this.price = price;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.salesOrderStatus = salesOrderStatus;
    }
}
