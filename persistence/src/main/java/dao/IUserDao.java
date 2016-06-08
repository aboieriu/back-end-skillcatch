package dao;


import model.Badge;
import model.ProjectGroup;
import model.Task;
import model.User;

import java.util.List;
import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    public void updateUser(User myUser);
    public User getUser(Long groupId,Long userId);
    public void deleteUser(Long groupId , Long userId);
    public User findByUserName(String username);

    Set<ProjectGroup> getAssignedProjects(Long userId);

    Set<Task> getUserTasks(Long userId);
    Set<Badge> getUserBadges(Long userId);


}
