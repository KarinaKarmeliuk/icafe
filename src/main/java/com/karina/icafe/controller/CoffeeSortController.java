package com.karina.icafe.controller;

import com.karina.icafe.dao.impl.CoffeeSortDaoImpl;
import com.karina.icafe.model.CoffeeSort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoffeeSortController {

    @Autowired
    private CoffeeSortDaoImpl coffeeSortDaoImpl;

    private List coffeeSortList;

    public CoffeeSortController() {
        try {
            coffeeSortList = coffeeSortDaoImpl.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List getCoffeeSortList() {
        return coffeeSortList;
    }

    public void setCoffeeSortList(List<CoffeeSort> coffeeSortList) {
        this.coffeeSortList = coffeeSortList;
    }
}
