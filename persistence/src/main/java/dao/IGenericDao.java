package dao;

import java.util.List;


public interface IGenericDao<T> {
    List<T> getAll();
    void add(T item);
    void deleteById(Long id);
    T getById(Long id);
    void update(Long id,T item);
}
