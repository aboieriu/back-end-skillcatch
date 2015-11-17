package facade;

import dao.IGroupDao;
import model.Group;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public class GroupFacade implements IGroupFacade{

    @Autowired
    private IGroupDao groupDao;

    public IGroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Group> getAllGroup(){
        return this.groupDao.getAll();
            }

   /* public Group getGroup(Long groupId){
    return this.groupDao.getGroup(groupId);}
*/
    public void addGroup(Group group){
        this.groupDao.add(group);
    }
/*
    public void deleteGroup(Long groupId){
        this.groupDao.deleteGroup(groupId);
    }
*/
    public void updateGroup(Group group){
        this.groupDao.updateGroup(group);
    }


}
