package dao;

import model.Badge;
import model.Group;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CataVlad on 29-Oct-15.
 */
public abstract class GenericDao<T> implements IGenericDao<T>{


    public Class<T> type;

    public GenericDao(Class<T> type){
        this.type = type;
    }
    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<T> getAll() {
        return this.entityManager.createQuery("from " + type.getName()).getResultList();
    }

    @Transactional
    public void add(T item){
        entityManager.persist(item);
    }

    @Transactional
    public T getById (Long id)
    {
        if (id == null) {
            return null;
        } else {
        return this.entityManager.find(type, id);
        }
    }
    @Transactional
    public void deleteById (Long id)
    {
        T itemFromDb = this.getById(id);
        this.entityManager.remove(itemFromDb);
    }
    /* @Transactional
    public void update(T item){
        T badgeFromDbs = this.getById(item.id());
        if (badgeFromDbs != null) {
            badgeFromDbs.setName(item.getName());
            badgeFromDbs.setDescription(item.getDescription());
            entityManager.persist(badgeFromDbs);
        }
    }*/


}
