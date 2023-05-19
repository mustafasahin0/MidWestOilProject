package com.midwestoil.service;

import com.midwestoil.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService extends CrudService<OrderItemDTO, Long> {

    void save(List<OrderItemDTO> orderItemDTOList);
}
