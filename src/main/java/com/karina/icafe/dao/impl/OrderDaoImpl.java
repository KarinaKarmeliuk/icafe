package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.OrderDao;
import com.karina.icafe.model.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

    public Order get(int id) {
        return getSessionFactory().getCurrentSession().get(Order.class, id);
    }

    public List<Order> getAll() {
        return getSessionFactory().getCurrentSession()
                .createQuery("SELECT a FROM Order a", Order.class)
                .getResultList();
    }

    public void add(Order order) {
        getHibernateTemplate().save(order);
    }

    public void update(Order order) {
        getHibernateTemplate().update(order);
    }

    public void delete(Order order) {
        getHibernateTemplate().delete(order);
    }
}
