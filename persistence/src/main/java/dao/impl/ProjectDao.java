package dao.impl;

import dao.api.IProjectDao;
import model.Project;
import model.TaskPlan;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public class ProjectDao extends GenericDao<Project> implements IProjectDao {

    public ProjectDao() {
        super(Project.class);
    }



    public Set<User> getUsers(Long groupId){
        Project targetGroup = this.getById(groupId);
        return targetGroup.getUsers();
    }


    public Set<TaskPlan> getTaskplans(Long groupId){
        Project targetGroup = this.getById(groupId);
        return targetGroup.getTaskPlans();
    }

    @Transactional
    public void updateGroup(Project group){
        Project groupFromDbs = this.getById(group.getId());
        if (groupFromDbs != null) {
            groupFromDbs.setName(group.getName());
            groupFromDbs.setDescriptions(group.getDescriptions());
            entityManager.persist(groupFromDbs);
        }
    }
}

