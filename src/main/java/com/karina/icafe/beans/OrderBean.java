package com.karina.icafe.beans;

import com.karina.icafe.bo.CalculationService;
import com.karina.icafe.dao.CoffeeSortDao;
import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.model.Order;
import com.karina.icafe.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SessionScope
public class OrderBean implements Serializable
{
    @Autowired
    private OrderDao orderDao;

    // @Autowired
    // private OrderItemBean orderItemBean;

    @Autowired
    private CoffeeSortDao coffeeSortDao;

    private Order order;

    private List<OrderItem> orderItemList;

    public OrderBean() {
        order = new Order();
        orderItemList = new LinkedList<>();
    }

    public String submit() {
        order.setOrderItemList(orderItemList);
        order.setDateTime(new Date());
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

    public void setOrderItemList(final List<OrderItem> orderItemList)
    {
        this.orderItemList = orderItemList;
    }

    public List<OrderItem> getOrderItemList()
    {
        return orderItemList;
    }

    public String getCoffeeSortNameById(int id) {
        return coffeeSortDao.get(id).getSortName();
    }

    public String getCoffeePriceById(int id) {
        return String.valueOf(coffeeSortDao.get(id).getPrice());
    }
}
