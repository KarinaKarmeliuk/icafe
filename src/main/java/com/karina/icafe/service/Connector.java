package com.karina.icafe.service;

import com.karina.icafe.dto.OrderDto;
import com.karina.icafe.dto.OrderItemDto;

import java.util.List;

public class Connector {

    private List<OrderItemDto> orderItemDtoList;

    private OrderDto orderDto;

    public List<OrderItemDto> getOrderItemDtoList()
    {
        return orderItemDtoList;
    }

    public void setOrderItemDtoList(final List<OrderItemDto> orderItemDtoList)
    {
        this.orderItemDtoList = orderItemDtoList;
    }

    public OrderDto getOrderDto()
    {
        return orderDto;
    }

    public void createOrderDto() {
        orderDto = new OrderDto();
    }

    public void destroyOrderDto() {
        orderDto = null;
    }
}
