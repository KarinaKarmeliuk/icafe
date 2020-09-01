package com.karina.icafe.beans;

import com.karina.icafe.bo.CalculationService;
import com.karina.icafe.dao.CoffeeSortDao;
import com.karina.icafe.dao.OrderItemDao;
import com.karina.icafe.model.CoffeeSort;
import com.karina.icafe.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScope
public class OrderItemBean implements Serializable {

    // @Autowired
    // private OrderItemDao orderItemDao;
    //
    // @Autowired
    // private CoffeeSortDao coffeeSortDao;

    @Autowired
    private CoffeeSortBean coffeeSortBean;

    @Autowired
    private OrderBean orderBean;

    @Autowired
    private CalculationService calculationService;

    private Map<Integer, String> selectedCoffeeSortMap;

    public OrderItemBean() {
        selectedCoffeeSortMap = new HashMap<>();
    }

    public String submit() {
        // preparing order
        for(CoffeeSort coffeeSort : coffeeSortBean.getCoffeeSortList())
        {
            if(!coffeeSort.isSelected()) {
                selectedCoffeeSortMap.remove(coffeeSort.getId());
            }
        }

        for(final Integer id : selectedCoffeeSortMap.keySet())
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(Integer.parseInt(selectedCoffeeSortMap.get(id)));
            orderItem.setIdCoffeeSort(id);
            orderBean.getOrderItemList().add(orderItem);
        }

        orderBean.getOrder().setCoffeeCost(calculationService.calculateCoffeeCost(selectedCoffeeSortMap));
        orderBean.getOrder().setDeliveryCost(calculationService.calculateDeliveryCost(orderBean.getOrder().getCoffeeCost()));
        orderBean.getOrder().setTotalCost(calculationService.calculateTotalCost(orderBean.getOrder().getCoffeeCost(), orderBean.getOrder().getDeliveryCost()));

        return "orderForm";
    }

    public Map<Integer, String> getSelectedCoffeeSortMap()
    {
        return selectedCoffeeSortMap;
    }

}
