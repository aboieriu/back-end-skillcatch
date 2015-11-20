package facade;

import model.Taskplan;
import model.User;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IUserFacade {


    public User getUser(Long groupId, Long userId);
   // public void deleteUser(Long groupId, Long userId);

    public void addUser(User user);
    public List<User> getAll();
    public User getUserById(Long userId);
    public void deleteUserById(Long userId);
    public void updateUser(User user);
}
