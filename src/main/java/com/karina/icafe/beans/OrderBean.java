package com.karina.icafe.beans;

import com.karina.icafe.dao.impl.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class OrderBean implements Serializable
{

    @Autowired
    private OrderDaoImpl orderDao;

}
