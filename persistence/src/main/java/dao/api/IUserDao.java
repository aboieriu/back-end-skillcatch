package dao.api;


import model.Badge;
import model.Project;
import model.Task;
import model.User;

import java.util.List;
import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    void updateUser(User myUser);
    User findByUserName(String username);
    void deleteUserById(Long userId);
    Set<Badge> getUserBadges(Long userId);
    void assignUserToProject(User userFromDbs);
    List<User> getProjectUnAssignedUsers(Long projectId);
}
