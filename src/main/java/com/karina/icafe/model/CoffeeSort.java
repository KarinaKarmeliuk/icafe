package com.karina.icafe.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coffee_sorts")
public class CoffeeSort implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "sort_name", nullable = false)
    private String sortName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "disabled")
    private boolean disabled;

    @Transient
    private boolean selected;

    @Transient
    private int cupQuantity;

    public CoffeeSort() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(final boolean disabled)
    {
        this.disabled = disabled;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(final boolean selected)
    {
        this.selected = selected;
    }

    public int getCupQuantity()
    {
        return cupQuantity;
    }

    public void setCupQuantity(final int cupQuantity)
    {
        this.cupQuantity = cupQuantity;
    }
}
