package facade;
import model.Badge;
import model.User;

import java.util.List;
import java.util.Set;


public interface IUserFacade {
    public User getUserFromGroup(Long groupId,Long userId);
    public void addUser(User user);
    public List<User> getAll();
    public User getUserById(Long userId);
    public void deleteUserById(Long userId);
    public void updateUser(User user);
    public User findByUserName(String username);
    Set<Badge> getBadgeForUser(Long id);
}
