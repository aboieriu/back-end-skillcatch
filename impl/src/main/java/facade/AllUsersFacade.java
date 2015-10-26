package facade;

import dao.IAllUsersDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public class AllUsersFacade implements IAllUsersFacade{


    @Autowired
    private IAllUsersDao allUsersDao;

    public void setAllUsersDao(IAllUsersDao allUsersDao) {
        this.allUsersDao = allUsersDao;
    }

    public IAllUsersDao getAllUsersDao() {

        return allUsersDao;
    }

    public List<User> getAllUsers(){
        return this.allUsersDao.getAllUsers();
    }


}
