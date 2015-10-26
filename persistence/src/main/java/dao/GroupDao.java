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

    public Group getGroupByDate(Date startDate,Date endDate)
    {
        Query query = this.entityManager.createQuery("from Group WHERE startDate=:startDate AND endDate=:endDate");
        query.setParameter("startDate",startDate);
        query.setParameter("endDate",endDate);
        return (Group)query.getSingleResult();

    }


    @Transactional
    public void addGroup(Group item){
        Group groupFromDbs=this.getGroupByDate(item.getStartDate(),item.getEndDate());
        if (groupFromDbs!=null)
        {
            groupFromDbs.setStartDate(item.getStartDate());
            groupFromDbs.setEndDate(item.getEndDate());
        }
        entityManager.persist(item);
    }

    @Transactional
    public void updateGroup(Group group){
        Group groupFromDbs = this.getGroup(group.getGroupId());
        if (groupFromDbs != null) {
            groupFromDbs.setName(group.getName());
            groupFromDbs.setEndDate(group.getEndDate());
            groupFromDbs.setStartDate(group.getStartDate());
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