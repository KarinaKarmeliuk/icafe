package com.karina.icafe.dao;

import com.karina.icafe.model.CoffeeSort;

import java.util.List;

public interface CoffeeSortDao extends Dao<CoffeeSort> {
    @Override
    CoffeeSort get(int id);

    @Override
    List<CoffeeSort> getAll();

    @Override
    void add(CoffeeSort coffeeSort);

    @Override
    void update(CoffeeSort coffeeSort);

    @Override
    void delete(CoffeeSort coffeeSort);
}
