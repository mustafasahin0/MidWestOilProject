package com.midwestoil.service.impl;

import com.midwestoil.dto.CompanyDTO;
import com.midwestoil.dto.ContractDTO;
import com.midwestoil.dto.SalesOrderDTO;
import com.midwestoil.enums.Status;
import com.midwestoil.service.ContractService;
import com.midwestoil.service.OrderItemService;
import com.midwestoil.service.SalesOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContractServiceImpl extends AbstractMapService<ContractDTO, Long> implements ContractService {


    @Override
    public ContractDTO save(ContractDTO object) {
        if(object.getContractId() == null) {
            object.setContractId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(object.getContractId(), object);
    }

    @Override
    public List<ContractDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ContractDTO object) {
        super.update(object.getContractId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public ContractDTO findById(Long id) {
        return super.findById(id);
    }
}