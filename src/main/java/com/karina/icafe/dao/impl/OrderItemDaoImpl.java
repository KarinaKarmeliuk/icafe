package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.OrderItemDao;
import com.karina.icafe.model.OrderItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public class OrderItemDaoImpl extends HibernateDaoSupport implements OrderItemDao {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    void init () {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public OrderItem get(int id) {
        return getHibernateTemplate().getSessionFactory().getCurrentSession().get(OrderItem.class, id);
    }

    @Transactional
    public List<OrderItem> getAll() {
        List list = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("SELECT a FROM OrderItem a", OrderItem.class).getResultList();
        List<OrderItem> orderItemList = new LinkedList<>();
        for (final Object obj : list)
        {
            orderItemList.add((OrderItem)obj);
        }
        return orderItemList;
    }

    @Transactional
    public void add(OrderItem orderItem) {
        getHibernateTemplate().save(orderItem);
    }

    @Transactional
    public void update(OrderItem orderItem) {
        getHibernateTemplate().update(orderItem);
    }

    @Transactional
    public void delete(OrderItem orderItem) {
        getHibernateTemplate().delete(orderItem);
    }
}
