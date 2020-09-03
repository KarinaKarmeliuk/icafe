package com.karina.icafe.service;

import com.karina.icafe.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@SessionScope
public class CalculationService {

    @Value("${icafe.settings.order.free-cup-rate}")
    private int freeCupRate;

    @Value("${icafe.settings.order.delivery-cost}")
    private int deliveryCost;

    @Value("${icafe.settings.order.total-items-cost-for-free-delivery}")
    private int totalItemsCostForFreeDelivery;

    public void calculateOrderItems(List<OrderItemDto> orderItemDtoList) {

        for(OrderItemDto orderItemDto : orderItemDtoList)
        {
            int quantity = orderItemDto.getQuantity();
            int freeQuantity = quantity / freeCupRate;
            double itemCost = orderItemDto.getPrice() * (quantity - freeQuantity);
            orderItemDto.setItemCost(itemCost);
        }
    }

    public double calculateTotalItemsCost(List<OrderItemDto> orderItemDtoList) {

        double totalItemsCost = 0.0;

        for(OrderItemDto  orderItemDto : orderItemDtoList)
        {
            totalItemsCost += orderItemDto.getItemCost();
        }

        return totalItemsCost;
    }

    public double calculateDeliveryCost(double totalItemsCost) {
        if(totalItemsCost > totalItemsCostForFreeDelivery)
            deliveryCost = 0;
        return deliveryCost;
    }

    public double calculateTotalCost(double totalItemsCost, double deliveryCost) {
        return totalItemsCost + deliveryCost;
    }
}
