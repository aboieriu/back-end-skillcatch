package facade;

import dao.IGenericDao;
import dao.IGroupDao;
import model.Group;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



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

    public Group getGroupById(Long groupId){
        return this.groupDao.getById(groupId);}

    public void addGroup(Group group){
        this.groupDao.add(group);
    }

    public void deleteGroup(Long groupId){
        this.groupDao.deleteById(groupId);
    }

    public void updateGroup(Group group){
        this.groupDao.updateGroup(group);
    }
}
