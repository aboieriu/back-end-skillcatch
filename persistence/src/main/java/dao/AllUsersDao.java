package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by DELIA on 26.10.2015.
 */
public class AllUsersDao implements IAllUsersDao {

    private EntityManager entityManager ;

    @PersistenceContext
    private void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public List<User> getAllUsers() {
        return this.entityManager.createQuery("from User").getResultList();
    }
}
