package com.karina.icafe.beans;

import com.karina.icafe.dao.impl.OrderItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class OrderItemBean implements Serializable
{
    @Autowired
    private OrderItemDaoImpl orderItemDao;
}
