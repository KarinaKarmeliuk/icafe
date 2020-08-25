package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public class OrderItemDaoImpl implements Dao<OrderItem> {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public OrderItem get(long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        OrderItem orderItem = session.get(OrderItem.class, id);
        session.getTransaction().commit();
        session.close();
        return orderItem;
    }

    public List<OrderItem> getAll() {
        List<OrderItem> orderItemList = new LinkedList<>();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List list = session.createSQLQuery("SELECT * FROM order_items").addEntity(OrderItem.class).list();
        session.getTransaction().commit();
        session.close();
        for(final Object obj : list)
        {
            orderItemList.add((OrderItem)obj);
        }
        return orderItemList;
    }

    public void add(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(orderItem);
        session.getTransaction().commit();
        session.close();
    }

    public void update(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(orderItem);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(OrderItem orderItem) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(orderItem);
        session.getTransaction().commit();
        session.close();
    }
}
