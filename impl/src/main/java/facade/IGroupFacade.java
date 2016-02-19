package facade;

import model.ProjectGroup;
import model.Taskplan;
import model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IGroupFacade {
     void addGroup(ProjectGroup group);
     List<ProjectGroup> getAllGroup();
     ProjectGroup getGroupById(Long groupId);
     void deleteGroup(Long groupId);
     void updateGroup(ProjectGroup group);
  //  public void getUserFromGroup(Long groupId , Long userId);
     void addUserToGroup(Long groupId , Long userId);
     Set<User> getUsers(Long groupId);
     void addTaskPlanToGroup(Long groupId , Taskplan taskplan);
     Set<Taskplan> getTaskPlans(Long groupId);

}
