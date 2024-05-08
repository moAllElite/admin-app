package com.groupeisi.property.services;


import java.util.List;

public interface AbstractService<T> {
    T save(T t);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
    T update(String id,T t);

}
