package dao;

import model.Badge;

import java.util.List;
import java.util.Set;

/**
 * Created by CataVlad on 29-Oct-15.
 */
public interface IGenericDao<T> {
    List<T> getAll();
    void add(T item);
    void deleteById(Long id);
    T getById(Long id);
    void update(Long id,T item);
}
