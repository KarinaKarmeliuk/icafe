package com.karina.icafe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    // @Column(name = "id_coffee_sort")
    // private int id_coffee_sort;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CoffeeSort coffeeSort;

    public OrderItem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CoffeeSort getCoffeeSort()
    {
        return coffeeSort;
    }

    public void setCoffeeSort(final CoffeeSort coffeeSort)
    {
        this.coffeeSort = coffeeSort;
    }

    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && quantity == orderItem.quantity && Objects.equals(order, orderItem.order) && Objects.equals(coffeeSort, orderItem.coffeeSort);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, order, quantity, coffeeSort);
    }
}
