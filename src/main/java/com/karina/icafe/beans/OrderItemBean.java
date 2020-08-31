package com.karina.icafe.beans;

import com.karina.icafe.dao.OrderItemDao;
import com.karina.icafe.model.CoffeeSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScope
public class OrderItemBean implements Serializable {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CoffeeSortBean coffeeSortBean;

    private Map<Integer, Integer> selectedCoffeeSortMap;

    public OrderItemBean() {
        selectedCoffeeSortMap = new HashMap<>();
    }

    public String submit() {
        for(CoffeeSort coffeeSort : coffeeSortBean.getCoffeeSortList())
        {
            if(!coffeeSort.isSelected()) {
                selectedCoffeeSortMap.remove(coffeeSort.getId());
            }
        }

        return "orderForm";
    }

    public Map<Integer, Integer> getSelectedCoffeeSortMap()
    {
        return selectedCoffeeSortMap;
    }

    public void addToSelectedCoffeeSortMap(Integer id, Integer quantity) {
        selectedCoffeeSortMap.put(id, quantity);
    }
}
