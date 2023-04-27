package org.example.repository;

import java.util.List;

public interface ICrudRepository<T> {

    void add(T t);
    void deleteById(Long id);
    List<T> findAll();
    T findById(Long id);
    void update(T t);

}
