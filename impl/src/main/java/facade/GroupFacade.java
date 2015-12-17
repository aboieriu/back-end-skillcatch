package facade;

import dao.IGenericDao;
import dao.IGroupDao;
import dao.IUserDao;
import model.Group;
import model.Taskplan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public class GroupFacade implements IGroupFacade{

    @Autowired
    private IGroupDao groupDao;
    @Autowired
    private IUserDao userDao;

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
        this.groupDao.update(group.getId(), group);
    }


    public void addUserToGroup(Long groupId , Long userId){
        User targetUser = this.userDao.getById(userId);
        Group targetGroup = this.groupDao.getById(groupId);
        targetGroup.getUsers().add(targetUser);
        this.updateGroup(targetGroup);
    }

    public Set<User> getUsers(Long groupId){
        return this.groupDao.getUsers(groupId);
    }


    public void addTaskPlanToGroup(Long groupId , Taskplan taskplan){
        Group targetGroup = this.groupDao.getById(groupId);
        targetGroup.getTaskplans().add(taskplan);
        this.updateGroup(targetGroup);
    }

    public Set<Taskplan> getTaskPlans(Long groupId){
        return this.groupDao.getTaskplans(groupId);
    }

}
