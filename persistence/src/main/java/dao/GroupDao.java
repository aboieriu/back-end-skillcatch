package dao;

import model.ProjectGroup;
import model.Taskplan;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


public class GroupDao extends GenericDao<ProjectGroup> implements IGroupDao {

    public GroupDao() {
        super(ProjectGroup.class);
    }



    public Set<User> getUsers(Long groupId){
        ProjectGroup targetGroup = this.getById(groupId);
        return targetGroup.getUsers();
    }


    public Set<Taskplan> getTaskplans(Long groupId){
        ProjectGroup targetGroup = this.getById(groupId);
        return targetGroup.getTaskplans();
    }

    @Transactional
    public void updateGroup(ProjectGroup group){
        ProjectGroup groupFromDbs = this.getById(group.getId());
        if (groupFromDbs != null) {
            groupFromDbs.setName(group.getName());
            groupFromDbs.setDescriptions(group.getDescriptions());
            groupFromDbs.setStatus(group.getStatus());
            entityManager.persist(groupFromDbs);
        }

    }

    }

