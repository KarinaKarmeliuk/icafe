package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDaoImpl implements Dao<Order> {

    @Autowired
    SessionFactory sessionFactory;

    public Order get(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        transaction.commit();
        return order;
    }

    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List orderList = session.createSQLQuery("SELECT * FROM orders").
                addEntity(Order.class).list();
        transaction.commit();
        return orderList;
    }

    public void add(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
    }

    public void update(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
    }

    public void delete(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(order);
        transaction.commit();
    }
}