package dao.api;


import model.Badge;
import model.Project;
import model.Task;
import model.User;

import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    public void updateUser(User myUser);
    public User getUser(Long groupId,Long userId);
    public void deleteUser(Long groupId , Long userId);
    public User findByUserName(String username);

    Set<Project> getAssignedProjects(Long userId);

    Set<Task> getUserTasks(Long userId);
    Set<Badge> getUserBadges(Long userId);


}
