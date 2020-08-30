package com.karina.icafe.dao;

import com.karina.icafe.model.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    @Override
    Order get(int id);

    @Override
    List<Order> getAll();

    @Override
    void add(Order order);

    @Override
    void update(Order order);

    @Override
    void delete(Order order);
}
