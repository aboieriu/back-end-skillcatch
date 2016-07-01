package facade.impl;

import converter.ProjectConverter;
import dao.api.IProjectDao;
import dao.api.IUserDao;
import facade.api.IGroupFacade;
import facade.api.IProjectFacade;
import model.Project;
import model.TaskPlan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.ProjectView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class GroupFacade implements IGroupFacade {

    @Autowired
    private IProjectDao groupDao;
    @Autowired
    private IUserDao userDao;




    public IProjectDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(IProjectDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Project> getAllGroup(){
        return this.groupDao.getAll();
    }

    public Project getGroupById(Long groupId){
        return this.groupDao.getById(groupId);}

    public void addGroup(Project group){
        this.groupDao.add(group);
    }

    public void deleteGroup(Long groupId){
        this.groupDao.deleteById(groupId);
    }

    public void updateGroup(Project group){
        this.groupDao.updateGroup(group);
    }

    public void addUserToGroup(Long groupId , Long userId){
        User targetUser = this.userDao.getById(userId);
        Project targetGroup = this.groupDao.getById(groupId);
        targetGroup.getUsers().add(targetUser);
        this.updateGroup(targetGroup);
    }

    public void addTaskPlanToGroup(Long groupId , TaskPlan taskplan){
        Project targetGroup = this.groupDao.getById(groupId);
        targetGroup.getTaskPlans().add(taskplan);
        this.updateGroup(targetGroup);
    }

    public Set<User> getUsers(Long groupId){
        return this.groupDao.getUsers(groupId);
    }

    public Set<TaskPlan> getTaskPlans(Long groupId){
        return this.groupDao.getTaskplans(groupId);
    }

    public Set<Project> getAllProjects(){
        return this.groupDao.getAllProjects();
    }

}
