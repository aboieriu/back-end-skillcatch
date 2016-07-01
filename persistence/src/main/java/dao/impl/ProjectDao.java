package dao.impl;

import dao.api.IProjectDao;
import model.Project;
import model.TaskPlan;
import model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
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

    public Set<Project> getAllProjects(){
        Query query =this.entityManager.createQuery("from Project");

        List<Project> result = query.getResultList();
        if (!result.isEmpty()){
            return new HashSet<Project>(result);
        }
        throw new EmptyResultDataAccessException("No result for this id!", 1);
    }
}

