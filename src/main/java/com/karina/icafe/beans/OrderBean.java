package com.karina.icafe.beans;

import com.karina.icafe.bo.CalculationService;
import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.model.Order;
import com.karina.icafe.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

    private List<OrderItem> orderItemList;

    public OrderBean() {
        order = new Order();
        orderItemList = new LinkedList<>();
    }

    @PostConstruct
    void init() {
        for(final Integer id : orderItemBean.getSelectedCoffeeSortMap().keySet())
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(Integer.parseInt(orderItemBean.getSelectedCoffeeSortMap().get(id)));
            orderItem.setIdCoffeeSort(id);
            orderItemList.add(orderItem);
        }

        order.setCoffeeCost(calculationService.calculateCoffeeCost(orderItemBean.getSelectedCoffeeSortMap()));
        order.setDeliveryCost(calculationService.calculateDeliveryCost(order.getCoffeeCost()));
        order.setTotalCost(calculationService.calculateTotalCost(order.getCoffeeCost(), order.getDeliveryCost()));
        //orderItemDao.add(orderItem);
    }

    public String submit() {
        order.setOrderItemList(orderItemList);
        orderDao.add(order);
        return "orderConfirm";
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(final Order order)
    {
        this.order = order;
    }

    public List<OrderItem> getOrderItemList()
    {
        return orderItemList;
    }
}
