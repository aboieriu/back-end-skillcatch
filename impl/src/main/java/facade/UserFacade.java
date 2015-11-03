package facade;

import dao.IUserDao;
import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public class UserFacade implements IUserFacade{

    @Autowired
    private IUserDao userDao;

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory.SessionFactoryOptions findByUserName(String username){
        return this.sessionFactory.getSessionFactoryOptions();
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUser(Long groupId)
    {
        return this.userDao.getAllUsers(groupId);
    }

    public User getUser(Long groupId, Long userId)
    {
        return this.userDao.getUser(groupId,userId);
    }

    public void deleteUser(Long groupId, Long userId)
    {
        this.userDao.deleteUser(groupId, userId);
    }

    public void addUser(User group)
    {
        this.userDao.addUser(group);
    }

    public void updateUser(User group)
    {
        this.userDao.updateUser(group);
    }



}
