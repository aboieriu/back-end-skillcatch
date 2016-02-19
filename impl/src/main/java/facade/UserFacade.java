package facade;

import dao.IUserDao;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public class UserFacade implements IUserFacade{

    @Autowired
    private IUserDao userDao;





    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return this.userDao.getAll();
    }

    public User getUser(Long groupId, Long userId) {
        return this.userDao.getUser(groupId, userId);
    }


    public User getUserById(Long userId){
       return this.userDao.getById(userId) ;
    }

    /*public void deleteUser(Long groupId, Long userId) {
        this.userDao.deleteUser(groupId, userId);
    }*/


    public void deleteUserById(Long userId){
        this.userDao.deleteById(userId);
    }

    public void addUser(User group)
    {
        this.userDao.add(group);
    }

    public void updateUser(User group)
    {
        this.userDao.updateUser(group);
    }



    public User findByUserName(String username) {

        return this.userDao.findByUserName(username);
        }



}

