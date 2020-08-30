package com.karina.icafe.beans;

import com.karina.icafe.dao.OrderItemDao;
import com.karina.icafe.model.CoffeeSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@SessionScope
public class OrderItemBean implements Serializable {

    @Autowired
    private OrderItemDao orderItemDao;

    private CoffeeSort coffeeSort;

    private int quantity;

    public CoffeeSort getCoffeeSort()
    {
        return coffeeSort;
    }

    public void setCoffeeSort(final CoffeeSort coffeeSort)
    {
        this.coffeeSort = coffeeSort;
    }

    public void setQuantity(String quantity) {
        try
        {
            this.quantity = Integer.parseInt(quantity);
        } catch(NumberFormatException ex) {
            // inform user
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
