package com.karina.icafe.service;

import com.karina.icafe.dao.CoffeeSortDao;
import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.dto.CoffeeSortDto;
import com.karina.icafe.dto.OrderItemDto;
import com.karina.icafe.model.Order;
import com.karina.icafe.service.converter.CoffeeSortConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CoffeeService {
    @Autowired
    private CoffeeSortConverter coffeeSortConverter;

    @Autowired
    private CoffeeSortDao coffeeSortDao;

    @Autowired
    private OrderDao orderDao;

    public List<CoffeeSortDto> getCoffeeSortDtoList() {
        return coffeeSortConverter.convertToDtoList(coffeeSortDao.getAll());
    }

    public List<OrderItemDto> createOrderItemDtoList(List<CoffeeSortDto> coffeeSortDtoList) {
        List <OrderItemDto> orderItemDtoList = new ArrayList<>(coffeeSortDtoList.size());

        for(CoffeeSortDto coffeeSortDto : coffeeSortDtoList)
        {
            orderItemDtoList.add(new OrderItemDto(coffeeSortDto.getId(),
                                                  Integer.parseInt(coffeeSortDto.getCupQuantity()),
                                                  coffeeSortConverter.convertTo(coffeeSortDto),
                                                  coffeeSortDto.getSortName(),
                                                  coffeeSortDto.getPrice())
            );
        }
        return orderItemDtoList;
    }

    public void saveToDatabase(Order order) {
        orderDao.add(order);
    }
}
