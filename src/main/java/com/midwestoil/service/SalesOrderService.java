package com.midwestoil.service;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.Status;

import java.util.List;

public interface SalesOrderService extends CrudService<SalesOrderDTO, Long> {

    List<SalesOrderDTO> findSalesOrdersByClient(CompanyDTO companyDTO);

    List<SalesOrderDTO> findAllSalesOrdersByStatus(Status status);

    void updateStatus(SalesOrderDTO task);

}
