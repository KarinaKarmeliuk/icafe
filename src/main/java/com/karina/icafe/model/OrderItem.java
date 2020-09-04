package com.karina.icafe.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coffee_sort")
    private CoffeeSort coffeeSort;

    @Column(name = "quantity")
    private int quantity;

    public OrderItem() {}

    public OrderItem(OrderItem orderItem) {
        this.order = orderItem.getOrder();
        this.coffeeSort = orderItem.getCoffeeSort();
        this.quantity = orderItem.getQuantity();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(final Order order)
    {
        this.order = order;
    }

    public CoffeeSort getCoffeeSort()
    {
        return coffeeSort;
    }

    public void setCoffeeSort(final CoffeeSort coffeeSort)
    {
        this.coffeeSort = coffeeSort;
    }

}
