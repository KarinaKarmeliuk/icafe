package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.CoffeeSort;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class CoffeeSortDaoImpl implements Dao<CoffeeSort> {

    @Autowired
    SessionFactory sessionFactory;

    public CoffeeSort get(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CoffeeSort coffeeSort = session.get(CoffeeSort.class, id);
        transaction.commit();
        System.out.println("from get() CoffeeSortDaoImpl");
        return coffeeSort;
    }

    public List<CoffeeSort> getAll() {
        List <CoffeeSort> coffeeSortList = new LinkedList<>();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createSQLQuery("SELECT * FROM coffee_sorts").addEntity(CoffeeSort.class).list();
        transaction.commit();
        for (final Object obj : list)
        {
            coffeeSortList.add((CoffeeSort)obj);
        }
        return coffeeSortList;
    }

    public void add(CoffeeSort coffeeSort) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(coffeeSort);
        transaction.commit();
    }

    public void update(CoffeeSort coffeeSort) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(coffeeSort);
        transaction.commit();
    }

    public void delete(CoffeeSort coffeeSort) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(coffeeSort);
        transaction.commit();
    }
}
