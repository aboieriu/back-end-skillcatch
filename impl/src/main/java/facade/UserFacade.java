package facade;

import dao.IUserDao;
import model.Group;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<User> getAllUsers(Long groupId) {
        return this.userDao.getAllUsers(groupId);
    }
    public User getUser(Long groupId, Long userId) {
        return this.userDao.getUser(groupId, userId);
    }


    public User getUserById(Long userId){
       return this.userDao.getById(userId) ;
    }

    public void deleteUser(Long groupId, Long userId) {
        this.userDao.deleteUser(groupId, userId);
    }


    public void deleteUserById(Long userId){
        this.userDao.deleteById(userId);
    }

    public void addUser(User user)
    {
        this.userDao.add(user);
    }



    public void updateUser(User user)
    {
        this.userDao.updateUser(user);
    }
}

