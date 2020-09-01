package com.karina.icafe.beans;

import com.karina.icafe.dao.CoffeeSortDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.Map;

@SessionScope
@PropertySource("classpath:icafe_vars.properties")
public class CalculationService {

    //@Value("${icafe.settings.order.free-cup-rate}")
    private int freeCupRate = 5;

    //@Value("${icafe.settings.order.delivery-cost}")
    private int deliveryCost = 2;

    //@Value("${icafe.settings.order.total-coffee-cost-for-free-delivery}")
    private int totalCoffeeCostForFreeDelivery = 10;

    @Autowired
    private CoffeeSortDao coffeeSortDao;

    @Autowired
    Environment environment;

    // @PostConstruct
    // void init() {
    //     freeCupRate = Integer.parseInt(environment.getProperty("${icafe.settings.order.free-cup-rate}"));
    //     deliveryCost = Integer.parseInt(environment.getProperty("${icafe.settings.order.delivery-cost}"));
    //     totalCoffeeCostForFreeDelivery = Integer.parseInt("${icafe.settings.order.total-coffee-cost-for-free-delivery}");
    // }

    public double calculateCoffeeCost(Map<Integer, String> selectedCoffeeSortMap) {
        double totalCost = 0.0;
        double cost;
        for(Integer id : selectedCoffeeSortMap.keySet())
        {
            int quantity = Integer.parseInt(selectedCoffeeSortMap.get(id));
            int freeQuantity = quantity / freeCupRate;
            cost = coffeeSortDao.get(id).getPrice() * (quantity - freeQuantity);
            totalCost += cost;
        }
        return totalCost;
    }

    public double calculateDeliveryCost(double coffeeCost) {
        if(coffeeCost > totalCoffeeCostForFreeDelivery) {
            return 0;
        }
        else {
            return deliveryCost;
        }
    }

    public double calculateTotalCost(double coffeeCost, double deliveryCost) {
        return coffeeCost + deliveryCost;
    }

    public double calculateOrderItemCost(int id, int quantity) {
        double cost = 0.0;
        int freeQuantity = quantity / freeCupRate;
        cost = coffeeSortDao.get(id).getPrice() * (quantity - freeQuantity);
        return cost;
    }
}
