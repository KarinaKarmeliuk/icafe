package com.karina.icafe.dto;

import com.karina.icafe.model.CoffeeSort;

import java.io.Serializable;

public class OrderItemDto implements Serializable
{
    private int id;
    private int quantity;
    private CoffeeSort coffeeSort;
    private String sortCoffeeName; // transient
    private double itemCost; // transient
    private double price; // transient

    public OrderItemDto() {}

    public OrderItemDto(final int id, final int quantity, CoffeeSort coffeeSort ,final String sortCoffeeName, final double price)
    {
        this.id = id;
        this.quantity = quantity;
        this.coffeeSort = coffeeSort;
        this.sortCoffeeName = sortCoffeeName;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(final int quantity)
    {
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

    public String getSortCoffeeName()
    {
        return sortCoffeeName;
    }

    public void setSortCoffeeName(final String sortCoffeeName)
    {
        this.sortCoffeeName = sortCoffeeName;
    }

    public double getItemCost()
    {
        return itemCost;
    }

    public void setItemCost(final double itemCost)
    {
        this.itemCost = itemCost;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(final double price)
    {
        this.price = price;
    }
}
