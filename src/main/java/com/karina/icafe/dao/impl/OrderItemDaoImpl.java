package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.OrderItemDao;
import com.karina.icafe.model.OrderItem;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class OrderItemDaoImpl extends HibernateDaoSupport implements OrderItemDao {

    public OrderItem get(int id) {
        return getSessionFactory().getCurrentSession().get(OrderItem.class, id);
    }

    public List<OrderItem> getAll() {
        return getHibernateTemplate().getSessionFactory().getCurrentSession()
                .createQuery("SELECT a FROM OrderItem a", OrderItem.class)
                .getResultList();
    }

    public void add(OrderItem orderItem) {
        getHibernateTemplate().save(orderItem);
    }

    public void update(OrderItem orderItem) {
        getHibernateTemplate().update(orderItem);
    }

    public void delete(OrderItem orderItem) {
        getHibernateTemplate().delete(orderItem);
    }
}
