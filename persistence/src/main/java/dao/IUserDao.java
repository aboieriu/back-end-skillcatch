package dao;

import model.Badge;
import model.User;

import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    public void updateUser(User myUser);
    public User getUser(Long groupId,Long userId);
    public void deleteUser(Long groupId , Long userId);
    public User findByUserName(String username);
    Set<Badge> getBadgeForUser(Long id);
}
