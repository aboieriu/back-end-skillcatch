package facade.api;

import model.Project;
import model.TaskPlan;
import model.User;

import java.util.List;
import java.util.Set;


public interface IGroupFacade {
    public void addGroup(Project group);
    public List<Project> getAllGroup();
    public Project getGroupById(Long groupId);
    public void deleteGroup(Long groupId);
    public void updateGroup(Project group);

    public void addUserToGroup(Long groupId , Long userId);
    public void addTaskPlanToGroup(Long groupId , TaskPlan taskplan);
    public Set<User> getUsers(Long groupId);

    public Set<TaskPlan> getTaskPlans(Long groupId);

}
