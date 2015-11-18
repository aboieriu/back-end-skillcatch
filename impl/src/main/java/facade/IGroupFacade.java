package facade;

import model.Group;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IGroupFacade {



    public Group getGroup(Long groupId);


    public void deleteGroup(Long groupId);

}