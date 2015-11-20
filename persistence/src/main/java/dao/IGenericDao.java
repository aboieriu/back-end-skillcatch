package dao;

import java.util.List;

/**
 * Created by CataVlad on 29-Oct-15.
 */
public interface IGenericDao<T> {
    public List<T> getAll();
    public void add(T item);
    public void deleteById(Long id);
    public T getById(Long id);
}
