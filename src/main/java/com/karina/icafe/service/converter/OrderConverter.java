package com.karina.icafe.service.converter;

import com.karina.icafe.dto.OrderDto;
import com.karina.icafe.model.Order;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderConverter {

    @Autowired
    private Mapper dozerMapper;

    public Order convertTo(OrderDto dto) {
        return dozerMapper.map(dto, Order.class);
    }

    public OrderDto convertTo(Order entity) {
        return dozerMapper.map(entity, OrderDto.class);
    }
}
