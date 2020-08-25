package com.karina.icafe.dao.impl;

import com.karina.icafe.dao.Dao;
import com.karina.icafe.model.CoffeeSort;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.LinkedList;
import java.util.List;

public class CoffeeSortDaoImpl implements Dao<CoffeeSort> {

    @Autowired
    SessionFactory sessionFactory;

    public CoffeeSort get(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        CoffeeSort coffeeSort = session.get(CoffeeSort.class, id);
        session.getTransaction().commit();
        session.close();
        System.out.println("from get() CoffeeSortDaoImpl");
        return coffeeSort;
    }

    public List<CoffeeSort> getAll() {
        List <CoffeeSort> coffeeSortList = new LinkedList<>();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List list = session.createSQLQuery("SELECT * FROM coffee_sorts").addEntity(CoffeeSort.class).list();
        session.getTransaction().commit();
        session.close();

        for (final Object obj : list)
        {
            coffeeSortList.add((CoffeeSort)obj);
        }
        return coffeeSortList;
    }

    public void add(CoffeeSort coffeeSort) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(coffeeSort);
        session.getTransaction().commit();
        session.close();
    }

    public void update(CoffeeSort coffeeSort) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(coffeeSort);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(CoffeeSort coffeeSort) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(coffeeSort);
        session.getTransaction().commit();
        session.close();
    }
}
