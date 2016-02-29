package facade;

import model.ProjectGroup;
import model.Taskplan;
import model.User;

import java.util.List;
import java.util.Set;


public interface IGroupFacade {
    public void addGroup(ProjectGroup group);
    public List<ProjectGroup> getAllGroup();
    public ProjectGroup getGroupById(Long groupId);
    public void deleteGroup(Long groupId);
    public void updateGroup(ProjectGroup group);

    public void addUserToGroup(Long groupId , Long userId);
    public Set<User> getUsers(Long groupId);

    public Set<Taskplan> getTaskPlans(Long groupId);

}
