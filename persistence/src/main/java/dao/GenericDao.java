package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


public abstract class GenericDao<T> implements IGenericDao<T>{


    public Class<T> type;

    public GenericDao(Class<T> type){
        this.type = type;
    }
    protected EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
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

        if (id==null) {
            return null;

        } else {

                Query query = this.entityManager.createQuery("from " + type.getName() + " where id=:id");
                query.setParameter("id", id);
                List<T> result = query.getResultList();
                if (!result.isEmpty()) {
                    return result.get(0);
                }
                throw new IllegalArgumentException("Not found!");
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
