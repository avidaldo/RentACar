package org.example.service;

import java.util.List;

public interface ICrudService<T> {

    void add(T t);
    void deleteById(Long id);
    List<T> findAll();
    void update(T t);

}
