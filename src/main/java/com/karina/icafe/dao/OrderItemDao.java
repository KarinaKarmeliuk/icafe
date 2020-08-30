package com.karina.icafe.dao;

import com.karina.icafe.model.OrderItem;

import java.util.List;

public interface OrderItemDao extends Dao<OrderItem> {

    @Override
    OrderItem get(int id);

    @Override
    List<OrderItem> getAll();

    @Override
    void add(OrderItem orderItem);

    @Override
    void update(OrderItem orderItem);

    @Override
    void delete(OrderItem orderItem);
}
