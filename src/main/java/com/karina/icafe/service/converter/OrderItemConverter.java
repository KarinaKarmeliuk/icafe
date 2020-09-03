package com.karina.icafe.service.converter;

import com.karina.icafe.dto.OrderItemDto;
import com.karina.icafe.model.OrderItem;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemConverter {

    @Autowired
    private Mapper dozerMapper;

    public OrderItem convertTo(OrderItemDto dto) {
        return dozerMapper.map(dto, OrderItem.class);
    }

    public OrderItemDto convertTo(OrderItem entity) {
        return dozerMapper.map(entity, OrderItemDto.class);
    }
}