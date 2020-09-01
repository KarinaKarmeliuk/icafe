package com.karina.icafe.bo;

import com.karina.icafe.dao.CoffeeSortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Map;

@SessionScope
// @PropertySource("classpath:icafe_vars.properties")
public class CalculationService {

    // @Value("${icafe.settings.order.free-cup-rate}")
    private String freeCupRate = "5";

    // @Value("${icafe.settings.order.delivery-cost}")
    private String deliveryCost = "2";

    // @Value("${icafe.settings.order.total-coffee-cost-for-free-delivery}")
    private String totalCoffeeCostForFreeDelivery = "10";

    @Autowired
    private CoffeeSortDao coffeeSortDao;

    public double calculateCoffeeCost(Map<Integer, String> selectedCoffeeSortMap) {
        double cost = 0.0;
        for(Integer id : selectedCoffeeSortMap.keySet())
        {
            int quantity = Integer.parseInt(selectedCoffeeSortMap.get(id));
            int freeQuantity = quantity / Integer.parseInt(freeCupRate);
            System.out.println("FREE quantity = " + freeQuantity);
            cost += coffeeSortDao.get(id).getPrice() * (quantity - freeQuantity);
        }
        return cost;
    }

    public double calculateDeliveryCost(double coffeeCost) {
        if(coffeeCost > Integer.parseInt(totalCoffeeCostForFreeDelivery)) {
            return 0;
        }
        else {
            return Integer.parseInt(deliveryCost);
        }
    }

    public double calculateTotalCost(double coffeeCost, double deliveryCost) {
        return coffeeCost + deliveryCost;
    }
}
