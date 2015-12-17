package facade;

import model.Group;
import model.Taskplan;
import model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IGroupFacade {
    public void addGroup(Group group);
    public List<Group> getAllGroup();
    public Group getGroupById(Long groupId);
    public void deleteGroup(Long groupId);
    public void updateGroup(Group group);
  //  public void getUserFromGroup(Long groupId , Long userId);
    public void addUserToGroup(Long groupId , Long userId);
    public Set<User> getUsers(Long groupId);
    public void addTaskPlanToGroup(Long groupId , Taskplan taskplan);
    public Set<Taskplan> getTaskPlans(Long groupId);

}
