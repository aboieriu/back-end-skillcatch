package facade;

import dao.IUserDao;
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


    public User getUser(Long groupId, Long userId)
    {
        return this.userDao.getUser(groupId,userId);
    }

    public void deleteUser(Long groupId, Long userId)
    {
        this.userDao.deleteUser(groupId, userId);
    }




}
