package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl implements Dao<Order> {

    @Autowired
    SessionFactory sessionFactory;

    public Order get(long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class, id);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    public List<Order> getAll() {
        List<Order> orderList = new LinkedList<>();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List list = session.createSQLQuery("SELECT * FROM orders").addEntity(Order.class).list();
        session.getTransaction().commit();
        session.close();
        for(final Object obj : list)
        {
            orderList.add((Order) obj);
        }
        return orderList;
    }

    public void add(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }
}
