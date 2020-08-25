package com.karina.icafe.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_item")
    private int orderItemID;

    @ManyToOne
    private Order order;

    @OneToOne
    private CoffeeSort coffeeSort;

    @Column(name = "quantity")
    private int quantity;

    public OrderItem() {}

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public CoffeeSort getCoffeeSort() {
        return coffeeSort;
    }

    public void setCoffeeSort(CoffeeSort coffeeSort) {
        this.coffeeSort = coffeeSort;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
