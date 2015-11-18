package facade;

import java.util.List;

public interface IGenericFacade<T>{
    public List<T> getAll();
    public void add(T item2);
    public void update(T item2);

}