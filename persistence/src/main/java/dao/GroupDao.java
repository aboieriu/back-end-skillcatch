package dao;

import model.Group;
import model.Taskplan;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public class GroupDao extends GenericDao<Group> implements IGroupDao {

    public GroupDao() {
        super(Group.class);
    }


    @Transactional
    public Set<User> getUsers(Long groupId){
        Group targetGroup = this.getById(groupId);
        return targetGroup.getUsers();
    }

    @Transactional
    public Set<Taskplan> getTaskplans(Long groupId){
        Group targetGroup = this.getById(groupId);
        return targetGroup.getTaskplans();
    }

}