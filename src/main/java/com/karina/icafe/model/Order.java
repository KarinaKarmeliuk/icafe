package com.karina.icafe.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time", nullable = false)
    private Date date_time;

    @Column(name="total_cost", nullable = false)
    private double totalCost;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date orderDateTime) {
        this.date_time = orderDateTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItem> getOrderItemList()
    {
        return orderItemList;
    }

    public void setOrderItemList(final List<OrderItem> orderItemList)
    {
        this.orderItemList = orderItemList;
    }
}
