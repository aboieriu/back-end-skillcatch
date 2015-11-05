package dao;

import model.Group;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public class GroupDao extends GenericDao<Group> implements IGroupDao {

    public GroupDao() {
        super(Group.class);
    }

    @Transactional
    public Group getGroup(Long id){
        if (id == null) {
            return null;
        } else {
            return entityManager.find(Group.class, id);
        }
    }

    @Transactional
    public void updateGroup(Group group){
        Group groupFromDbs = this.getGroup(group.getId());
        if (groupFromDbs != null) {
            groupFromDbs.setName(group.getName());
            groupFromDbs.setDescriptions(group.getDescriptions());
            groupFromDbs.setStatus(group.getStatus());
            entityManager.persist(groupFromDbs);
        }
    }
    @Transactional
    public void deleteGroup(Long id) {
        Group groupFromDbs= this.getGroup(id);
        if (groupFromDbs != null) {
            entityManager.remove(groupFromDbs);
        }
    }
}