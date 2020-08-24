package com.karina.icafe.model;

import com.karina.icafe.dao.impl.CoffeeSortDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee_sorts")
public class CoffeeSort implements Serializable {

    @Transient
    @Autowired
    private CoffeeSortDaoImpl coffeeSortDaoImpl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coffee_sort")
    private int coffeeSortID;

    @Column(name = "sort_name", nullable = false)
    private String sortName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "disabled")
    private String disabled;

    @OneToOne(mappedBy = "coffeeSort", cascade = CascadeType.ALL, orphanRemoval = true)
    private OrderItem orderItem;

    public CoffeeSort() {}

    public int getCoffeeSortID() {
        return coffeeSortID;
    }

    public void setCoffeeSortID(int coffeeSortID) {
        this.coffeeSortID = coffeeSortID;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDisabled() {
        return "Y".equals(disabled);
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = (disabled != null && disabled) ? "Y" : "";
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public OrderItem getOrderItem()
    {
        return orderItem;
    }

    public void setOrderItem(final OrderItem orderItem)
    {
        this.orderItem = orderItem;
    }
}
