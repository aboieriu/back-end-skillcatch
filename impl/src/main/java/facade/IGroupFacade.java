package facade;

import model.Group;
import model.User;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IGroupFacade {
    public void addGroup(Group group);
    public List<Group> getAllGroup();
    public Group getGroupById(Long groupId);
    public void deleteGroup(Long groupId);
    public void updateGroup(Group group);
    public void addUserToGroup(Long groupId , User user);
}
