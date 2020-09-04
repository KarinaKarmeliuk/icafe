package com.karina.icafe.controller;

import com.karina.icafe.dto.CoffeeSortDto;
import com.karina.icafe.dto.OrderItemDto;
import com.karina.icafe.service.CalculationService;
import com.karina.icafe.service.CoffeeService;
import com.karina.icafe.service.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScope
public class CoffeeSelectionController implements Serializable {

    @Autowired
    private Connector connector;

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CalculationService calculationService;

    private List<CoffeeSortDto> selectedCoffeeSortDtoList = new LinkedList<>();

    @PostConstruct
    void init() {
        connector.loadData();
    }

    public String submit() {
        for(CoffeeSortDto coffeeSortDto : connector.getCoffeeSortDtoList())
        {
            if(coffeeSortDto.isSelected()) {
                if(!coffeeSortDto.getCupQuantity().isEmpty())
                    selectedCoffeeSortDtoList.add(coffeeSortDto);
            }
        }

        if(selectedCoffeeSortDtoList.isEmpty())
            return "index";

        List<OrderItemDto> orderItemDtoList = coffeeService.createOrderItemDtoList(selectedCoffeeSortDtoList);
        calculationService.calculateOrderItems(orderItemDtoList);
        connector.setOrderItemDtoList(orderItemDtoList);

        connector.createOrderDto();

        connector.getOrderDto().setTotalItemsCost(
                calculationService.calculateTotalItemsCost(orderItemDtoList));

        connector.getOrderDto().setDeliveryCost(
                calculationService.calculateDeliveryCost(
                        connector.getOrderDto().getTotalItemsCost()));

        connector.getOrderDto().setTotalCost(
                calculationService.calculateTotalCost(
                        connector.getOrderDto().getTotalItemsCost(),
                        connector.getOrderDto().getDeliveryCost()
                )
        );

        cleanUp();

        return "orderForm";
    }

    private void cleanUp() {
        //coffeeSortDtoList.clear();
        selectedCoffeeSortDtoList.clear();
    }
}
