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
public class GroupDao implements IGroupDao {

    private EntityManager entityManager ;
    @PersistenceContext
    private void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    public List<Group> getAllGroup (){
        return this.entityManager.createQuery("from Group").getResultList();
    }

    @Transactional
    public Group getGroup(Long id){
        if (id == null) {
            return null;
        } else {
            return entityManager.find(Group.class, id);
        }

    }


    public Group getGroupById(Long id)

    {
        Query query = this.entityManager.createQuery("from Group WHERE id=:id");
        query.setParameter("id",id);
        return (Group)query.getSingleResult();

    }



    @Transactional
    public void addGroup(Group item){

        entityManager.persist(item);
    }

    @Transactional
    public void updateGroup(Group group){
        Group groupFromDbs = this.getGroup(group.getId());
        if (groupFromDbs != null) {
            groupFromDbs.setUser_name(group.getUser_name());
            groupFromDbs.setPassword(group.getPassword());
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