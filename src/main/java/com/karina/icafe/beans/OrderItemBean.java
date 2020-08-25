package com.karina.icafe.beans;

import com.karina.icafe.dao.impl.OrderItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@SessionScope
public class OrderItemBean implements Serializable
{
    @Autowired
    private OrderItemDaoImpl orderItemDao;

    private int quantity;

    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
