package facade;

import dao.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class GenericFacade<T> implements IGenericFacade<T> {

    @Autowired
    private IGenericDao item;

    public IGenericDao getItem() {
        return item;
    }


    public void setItem(IGenericDao item) {
        this.item = item;
    }

    public List<T> getAll() {

        return this.item.getAll();

    }

    public void add(T item2) {
        this.item.add(item2);
    }

    public void update(T item2) {

        //this.item.update(item2);
    }

    @Transactional
    public void deleteById (Long id)
    {
        T itemFromDb = this.getById(id);
        this.item.remove(itemFromDb);
    }
}

