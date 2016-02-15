package facade;
import model.User;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IUserFacade {
    public User getUserFromGroup(Long groupId,Long userId);
    public void deleteUser(Long groupId, Long userId);
    public void addUser(User user);
    public List<User> getAll();
    public User getUserById(Long userId);
    public void deleteUserById(Long userId);
    public void updateUser(User user);
    public User findByUserName(String username);

}
