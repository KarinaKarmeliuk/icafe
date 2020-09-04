package com.karina.icafe.controller;

import com.karina.icafe.dto.OrderItemDto;
import com.karina.icafe.model.Order;
import com.karina.icafe.model.OrderItem;
import com.karina.icafe.service.CoffeeService;
import com.karina.icafe.service.Connector;
import com.karina.icafe.service.converter.OrderConverter;
import com.karina.icafe.service.converter.OrderItemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionScope
public class OrderMakerController implements Serializable {

    @Autowired
    private Connector connector;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderItemConverter orderItemConverter;

    @Autowired
    private CoffeeService coffeeService;

    public String submit() {

        connector.getOrderDto().setDate_time(new Date());

        Order order = orderConverter.convertTo(connector.getOrderDto());
        List<OrderItem> orderItemList = new ArrayList<>();

        for(OrderItemDto orderItemDto : connector.getOrderItemDtoList())
        {
            orderItemList.add(orderItemConverter.convertTo(orderItemDto));
            orderItemList.get(orderItemList.size()-1).setOrder(order);
        }

        order.setOrderItemList(orderItemList);

        coffeeService.saveToDatabase(order);

        cleanUp();

        return "orderConfirm";
    }

    private void cleanUp() {
        connector.getOrderItemDtoList().clear();
        connector.destroyOrderDto();
    }
}
