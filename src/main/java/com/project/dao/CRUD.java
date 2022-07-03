package com.project.dao;

import java.util.List;

public interface CRUD<T> {

    List<T> listAll();

    T searchBydId(T t);

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);

    T searchByName(T t);
}
