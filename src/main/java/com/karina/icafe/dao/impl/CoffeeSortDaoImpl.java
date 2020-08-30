package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.CoffeeSortDao;
import com.karina.icafe.model.CoffeeSort;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

public class CoffeeSortDaoImpl extends HibernateDaoSupport implements CoffeeSortDao {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    void init () {
        setSessionFactory(sessionFactory);
    }

    @Transactional
    public CoffeeSort get(int id) {
        return getHibernateTemplate().getSessionFactory().getCurrentSession().get(CoffeeSort.class, id);
    }

    @Transactional(readOnly = true)
    public List<CoffeeSort> getAll() {
        List list = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("SELECT a FROM CoffeeSort a", CoffeeSort.class).getResultList();
        List<CoffeeSort> coffeeSortList = new LinkedList<>();
        for (final Object obj : list)
        {
            CoffeeSort coffeeSort = (CoffeeSort) obj;
            if(!coffeeSort.isDisabled())
                coffeeSortList.add(coffeeSort);
        }
        return coffeeSortList;
    }

    @Transactional
    public void add(CoffeeSort coffeeSort) {
        getHibernateTemplate().save(coffeeSort);
    }

    @Transactional
    public void update(CoffeeSort coffeeSort) {
        getHibernateTemplate().update(coffeeSort);
    }

    @Transactional
    public void delete(CoffeeSort coffeeSort) {
        getHibernateTemplate().delete(coffeeSort);
    }
}
