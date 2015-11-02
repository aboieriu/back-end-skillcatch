package dao;

import model.User;

import java.util.List;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IUserDao {

    User findByUserName(String username);
    public List<User> getAllUsers(Long id);
    public void addUser(User userId);
    public void updateUser(User myUser);
    public void deleteUser(Long groupId , Long userId);
    public User getUser(Long groupId,Long userId);

}
