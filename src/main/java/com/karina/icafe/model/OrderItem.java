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

    @Column(name = "id_coffee_sort")
    private int idCoffeeSort;

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

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(final Order order)
    {
        this.order = order;
    }

    public int getIdCoffeeSort()
    {
        return idCoffeeSort;
    }

    public void setIdCoffeeSort(final int idCoffeeSort)
    {
        this.idCoffeeSort = idCoffeeSort;
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
        return id == orderItem.id && quantity == orderItem.quantity && idCoffeeSort == orderItem.idCoffeeSort && Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, order, quantity, idCoffeeSort);
    }
}
