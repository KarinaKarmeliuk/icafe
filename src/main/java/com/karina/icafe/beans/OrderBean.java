package com.karina.icafe.beans;

import com.karina.icafe.dao.impl.OrderDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@SessionScope
public class OrderBean implements Serializable
{

    @Autowired
    private OrderDaoImpl orderDao;

}
