package facade.api;

import model.Badge;
import model.Task;
import model.TaskPlan;
import model.User;
import view.AssignedProjectView;
import view.UserView;


import java.util.List;
import java.util.Set;


public interface IUserFacade {

    void addUser(User user);
    User getUserById(Long userId);
    void deleteUserById(Long userId);
    void updateUser(User user);
    User findByUserName(String username);
    Set<Badge> getUserBadges(Long userId);
    Set<UserView> getAll();
    UserView getOne(Long userId);
    void assignUserToProject(Long userId, Long projectId);
    Set<UserView> getProjectUnAssignedUsers(Long projectId);
    void removeTaskPlanFromUser(Long userId, Long taskPlanId);
    void assignTaskPlanToUser(Long userId, Long taskPlanId);
    Set<TaskPlan> getUserTaskPlans(Long userId);
}