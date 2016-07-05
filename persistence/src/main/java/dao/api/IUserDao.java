package dao.api;


import model.Badge;
import model.Project;
import model.Task;
import model.User;

import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    void updateUser(User myUser);
    User getUser(Long groupId,Long userId);
    User findByUserName(String username);
    Set<Project> getAssignedProjects(Long userId);
    Set<Task> getUserTasks(Long userId);
    Set<Badge> getUserBadges(Long userId);
}
