package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemDaoImpl implements Dao<OrderItem> {

    @Autowired
    SessionFactory sessionFactory;

    public OrderItem get(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        OrderItem orderItem = session.get(OrderItem.class, id);
        transaction.commit();
        return orderItem;
    }

    public List getAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List orderItemList = session.createSQLQuery("SELECT * FROM order_items").
                addEntity(OrderItem.class).list();
        transaction.commit();
        return orderItemList;
    }

    public void add(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(orderItem);
        transaction.commit();
    }

    public void update(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(orderItem);
        transaction.commit();
    }

    public void delete(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(orderItem);
        transaction.commit();
    }
}
