package com.karina.icafe.bo;

import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class CalculationService {

    @Value("${icafe.settings.order.free-cup-rate}")
    private int freeCupRate;

    @Value("${icafe.settings.delivery-cost}")
    private int deliveryCost;

    @Value("${icafe.settings.total-cost-for-free-delivery}")
    private int totalCostForFreeDelivery;


    public double calculateCoffeeCost(Map<Integer, String> selectedCoffeeSortMap) {
        double cost = 0.0;

        return cost;
    }

    public double calculateDeliveryCost() {
        double cost = 0.0;

        return cost;
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;

        return totalCost;
    }
}
