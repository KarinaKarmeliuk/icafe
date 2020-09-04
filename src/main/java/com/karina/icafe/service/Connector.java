package com.karina.icafe.service;

import com.karina.icafe.dto.CoffeeSortDto;
import com.karina.icafe.dto.OrderDto;
import com.karina.icafe.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Connector {

    @Autowired
    private CoffeeService coffeeService;

    private List<CoffeeSortDto> coffeeSortDtoList;

    private List<OrderItemDto> orderItemDtoList;

    private OrderDto orderDto;

    public List<CoffeeSortDto> getCoffeeSortDtoList()
    {
        return coffeeSortDtoList;
    }

    public void setCoffeeSortDtoList(final List<CoffeeSortDto> coffeeSortDtoList)
    {
        this.coffeeSortDtoList = coffeeSortDtoList;
    }

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

    public void loadData() {
        setCoffeeSortDtoList(coffeeService.getCoffeeSortDtoList());
    }
}
