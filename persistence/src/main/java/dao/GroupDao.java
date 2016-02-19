package dao;

import model.ProjectGroup;
import model.Taskplan;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public class GroupDao extends GenericDao<ProjectGroup> implements IGroupDao {

    public GroupDao() {
        super(ProjectGroup.class);
    }


    @Transactional
    public Set<User> getUsers(Long groupId){
        ProjectGroup targetGroup = this.getById(groupId);
        return targetGroup.getUsers();
    }

    @Transactional
    public Set<Taskplan> getTaskplans(Long groupId){
        ProjectGroup targetGroup = this.getById(groupId);
        return targetGroup.getTaskplans();
    }

}