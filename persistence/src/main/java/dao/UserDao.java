package dao;

import model.Group;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public class UserDao extends GenericDao<User> implements IUserDao{

    public UserDao() {
        super(User.class);
    }


    @Transactional
    public User getUser(Long groupId,Long userId) {
        if(groupId !=null || userId != null)
        {
            Query query = this.entityManager.createQuery("from User WHERE groupId = :targetgroupId AND id = :targetuserId ");
            query.setParameter("targetgroupId" , groupId);
            query.setParameter("targetuserId" , userId);
            List<User> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }


    @Transactional
    public void updateUser(User myUser){
        User itemFromDbs = this.getById(myUser.getId());
        if (itemFromDbs != null) {
            itemFromDbs.setName(myUser.getName());
            itemFromDbs.setSurname(myUser.getSurname());
            itemFromDbs.setUsername(myUser.getUsername());
            itemFromDbs.setPassword(myUser.getPassword());
            itemFromDbs.setEmail(myUser.getEmail());
            itemFromDbs.setPhone(myUser.getPhone());
            entityManager.persist(itemFromDbs);
        }
    }
}
