package com.karina.icafe.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable
{
    private Date date_time;
    private double totalCost;
    private String clientName;
    private String deliveryAddress;
    private double totalItemsCost; // transient
    private double deliveryCost; // transient

    public Date getDate_time()
    {
        return date_time;
    }

    public void setDate_time(final Date date_time)
    {
        this.date_time = date_time;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(final double totalCost)
    {
        this.totalCost = totalCost;
    }

    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(final String clientName)
    {
        this.clientName = clientName;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(final String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotalItemsCost()
    {
        return totalItemsCost;
    }

    public void setTotalItemsCost(final double totalItemsCost)
    {
        this.totalItemsCost = totalItemsCost;
    }

    public double getDeliveryCost()
    {
        return deliveryCost;
    }

    public void setDeliveryCost(final double deliveryCost)
    {
        this.deliveryCost = deliveryCost;
    }
}
