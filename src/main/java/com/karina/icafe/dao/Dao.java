package com.karina.icafe.dao;

import java.util.List;

public interface Dao<T> {
    T get(int id);

    List getAll();

    void add(T t);

    void update(T t);

    void delete(T t);
}
