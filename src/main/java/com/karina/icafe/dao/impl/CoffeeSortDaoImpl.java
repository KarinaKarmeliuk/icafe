package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.CoffeeSortDao;
import com.karina.icafe.model.CoffeeSort;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class CoffeeSortDaoImpl extends HibernateDaoSupport implements CoffeeSortDao {


    public CoffeeSort get(int id) {
        return getSessionFactory().getCurrentSession().get(CoffeeSort.class, id);
    }

    public List<CoffeeSort> getAll() {
        return getSessionFactory().getCurrentSession()
                .createQuery("SELECT a FROM CoffeeSort a WHERE a.disabled = false", CoffeeSort.class)
                .getResultList();
    }

    public void add(CoffeeSort coffeeSort) {
        getHibernateTemplate().save(coffeeSort);
    }

    public void update(CoffeeSort coffeeSort) {
        getHibernateTemplate().update(coffeeSort);
    }

    public void delete(CoffeeSort coffeeSort) {
        getHibernateTemplate().delete(coffeeSort);
    }
}
