package dao.impl;

import dao.api.IGenericDao;
import model.Badge;
import model.Project;
import model.TaskPlan;
import model.User;
import org.hibernate.CacheMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.io.File;
import java.util.List;

public abstract class GenericDao<T> implements IGenericDao<T> {

    private Logger logger = LoggerFactory.getLogger(GenericDao.class);

    public Class<T> type;

    public GenericDao(Class<T> type) {
        this.type = type;
    }
    protected EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "blogPersistenceUnit")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<T> getAll() {

        Query query = this.entityManager.createQuery("from " + type.getName());
        List<T> result = query.getResultList();
        if (!result.isEmpty()) {
            return result;
        }

        throw new IllegalArgumentException("Not found!");
    }

    @Transactional
    public void add(T item) {
        entityManager.persist(item);
    }

    public T getById(Long id) {
        if (id == null) {
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
    public void deleteById(Long id) {
        T itemFromDb = this.getById(id);
        this.entityManager.remove(itemFromDb);
    }

    public boolean replacePicture(String dataBasePicture,String newPictureLocation) {
        String[] splittedUrl=dataBasePicture.split("/");
        String fileName=splittedUrl[splittedUrl.length-1];
        File file=new File(newPictureLocation+fileName);
        boolean exists=file.exists();
        boolean fileToBeDeleted=file.delete();
        return exists && fileToBeDeleted;
    }



}
