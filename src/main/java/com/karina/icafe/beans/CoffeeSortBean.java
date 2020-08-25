package com.karina.icafe.beans;

import com.karina.icafe.dao.impl.CoffeeSortDaoImpl;
import com.karina.icafe.model.CoffeeSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@SessionScope
public class CoffeeSortBean implements Serializable
{
    @Autowired
    private CoffeeSortDaoImpl coffeeSortDao;

    private List<CoffeeSort> coffeeSortList;

    @PostConstruct
    void init() {
        try {
            coffeeSortList = coffeeSortDao.getAll();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<CoffeeSort> getCoffeeSortList()
    {
        return coffeeSortList;
    }
}
