package com.midwestoil.service.impl;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.Status;
import com.midwestoil.service.SalesOrderService;
import com.midwestoil.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SalesOrderServiceImpl extends AbstractMapService<SalesOrderDTO, Long> implements SalesOrderService {


    @Override
    public SalesOrderDTO save(SalesOrderDTO object) {
        if (object.getSalesOrderStatus() == null) {
            object.setSalesOrderStatus(Status.OPEN);
        }

        if (object.getOrderDate() == null) {
            object.setOrderDate(LocalDate.now());
        }

        if (object.getSalesOrderId() == null) {
            long mostSignificantBits = Math.abs(UUID.randomUUID().getMostSignificantBits() % 900000) + 100000;
            object.setSalesOrderId(mostSignificantBits);
        }

        return super.save(object.getSalesOrderId(), object);
    }

    @Override
    public List<SalesOrderDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(SalesOrderDTO object) {
        SalesOrderDTO foundOrder = findById(object.getSalesOrderId());

        object.setSalesOrderStatus(foundOrder.getSalesOrderStatus());
        object.setOrderDate(foundOrder.getOrderDate());

        super.update(object.getSalesOrderId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public SalesOrderDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<SalesOrderDTO> findSalesOrdersByClient(CompanyDTO companyDTO) {
        return findAll().stream().filter(order -> order.getClient().toString().equals(companyDTO.getName())).collect(Collectors.toList());
    }

    @Override
    public List<SalesOrderDTO> findAllSalesOrdersByStatus(Status status) {
        return findAll().stream().filter(order -> order.getSalesOrderStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(SalesOrderDTO salesOrderDTO) {
        findById(salesOrderDTO.getSalesOrderId()).setSalesOrderStatus(salesOrderDTO.getSalesOrderStatus());
        update(salesOrderDTO);
    }
}