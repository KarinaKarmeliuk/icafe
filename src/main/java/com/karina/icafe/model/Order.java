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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time", nullable = false)
    private Date dateTime;

    @Transient
    private double coffeeCost;

    @Transient
    private double deliveryCost;

    @Column(name="total_cost", nullable = false)
    private double totalCost;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "delivery_address", nullable = false)
    private double deliveryAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date orderDateTime) {
        this.dateTime = orderDateTime;
    }

    public double getCoffeeCost() {
        return coffeeCost;
    }

    public void setCoffeeCost(double coffeeCost) {
        this.coffeeCost = coffeeCost;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
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

    public double getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(double deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

}
