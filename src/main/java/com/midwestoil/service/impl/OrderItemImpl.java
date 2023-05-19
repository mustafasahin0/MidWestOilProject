package com.midwestoil.service.impl;

import com.midwestoil.dto.OrderItemDTO;
import com.midwestoil.service.OrderItemService;
import com.midwestoil.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemImpl  extends AbstractMapService<OrderItemDTO, Long> implements OrderItemService {

    ProductService productService;

    public OrderItemImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public OrderItemDTO save(OrderItemDTO object) {
        if (object.getId() == null) {
            long mostSignificantBits = Math.abs(UUID.randomUUID().getMostSignificantBits() % 900000) + 100000;
            object.setId(mostSignificantBits);
        }
        object.setProduct(productService.findById(object.getProduct().getId()));
        return super.save(object.getId(), object);
    }
    @Override
    public void save(List<OrderItemDTO> orderItemDTOList) {
        for (OrderItemDTO item : orderItemDTOList) {
            if (item.getId() == null) {
                long mostSignificantBits = Math.abs(UUID.randomUUID().getMostSignificantBits() % 900000) + 100000;
                item.setId(mostSignificantBits);
            }
            item.setProduct(productService.findById(item.getProduct().getId()));
        }
    }

    @Override
    public List<OrderItemDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(OrderItemDTO object) {
        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public OrderItemDTO findById(Long id) {
        return super.findById(id);
    }


}
