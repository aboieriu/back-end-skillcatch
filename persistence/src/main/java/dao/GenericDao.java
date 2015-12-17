package dao;

import model.Badge;
import model.Group;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    @Transactional
    public void update(Long id,T item){
        if(item != null){
            T targetItem = this.getById(id);
            if(targetItem != null) {
                NullAwareBeanUtilsBean nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
                try {
                    nullAwareBeanUtilsBean.copyProperties(targetItem, item);
                    this.entityManager.persist(targetItem);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
