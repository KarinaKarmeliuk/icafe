package com.karina.icafe.beans;

import com.karina.icafe.bo.CalculationService;
import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.model.Order;
import com.karina.icafe.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@SessionScope
public class OrderBean implements Serializable
{
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemBean orderItemBean;

    @Autowired
    private CalculationService calculationService;

    private Order order;

    @PostConstruct
    void init() {
        for(final Integer id : orderItemBean.getSelectedCoffeeSortMap().keySet())
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(Integer.parseInt(orderItemBean.getSelectedCoffeeSortMap().get(id)));
            orderItem.setIdCoffeeSort(id);

            calculationService.calculateCoffeeCost(orderItemBean.getSelectedCoffeeSortMap());
            //orderItemDao.add(orderItem);
        }
    }

}
