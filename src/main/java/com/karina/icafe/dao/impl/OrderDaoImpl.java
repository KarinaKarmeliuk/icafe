package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    void init () {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public Order get(int id) {
        return getHibernateTemplate().getSessionFactory().getCurrentSession().get(Order.class, id);
    }

    @Transactional
    public List<Order> getAll() {
        List list = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Order a", Order.class).getResultList();
        List<Order> orderList = new LinkedList<>();
        for (final Object obj : list)
        {
            orderList.add((Order)obj);
        }
        return orderList;
    }

    @Transactional
    public void add(Order order) {
        getHibernateTemplate().save(order);
    }

    @Transactional
    public void update(Order order) {
        getHibernateTemplate().update(order);
    }

    @Transactional
    public void delete(Order order) {
        getHibernateTemplate().delete(order);
    }
}
