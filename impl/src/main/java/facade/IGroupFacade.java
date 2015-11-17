package facade;

import model.Group;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IGroupFacade {

    public List<Group> getAllGroup();


    //public Group getGroup(Long groupId);


    //public void deleteGroup(Long groupId);


    public void addGroup(Group group);


    public void updateGroup(Group group);

}
