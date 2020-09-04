package com.karina.icafe.dto;

import java.io.Serializable;
import java.util.Objects;

public class CoffeeSortDto implements Serializable
{
    private int id;
    private String sortName;
    private double price;
    private boolean selected; // transient
    private String cupQuantity; // transient

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public String getSortName()
    {
        return sortName;
    }

    public void setSortName(final String sortName)
    {
        this.sortName = sortName;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(final double price)
    {
        this.price = price;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(final boolean selected)
    {
        this.selected = selected;
    }

    public String getCupQuantity()
    {
        return cupQuantity;
    }

    public void setCupQuantity(final String cupQuantity)
    {
        this.cupQuantity = cupQuantity;
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
        CoffeeSortDto that = (CoffeeSortDto) o;
        return id == that.id && Double.compare(that.price, price) == 0 && selected == that.selected && Objects.equals(sortName, that.sortName) && Objects.equals(cupQuantity, that.cupQuantity);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, sortName, price, selected, cupQuantity);
    }
}
