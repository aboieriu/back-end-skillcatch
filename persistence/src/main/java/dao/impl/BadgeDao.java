package dao.impl;

import dao.api.IBadgeDao;
import model.Badge;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import java.util.List;


public class BadgeDao extends GenericDao<Badge> implements IBadgeDao {
    public BadgeDao() {
        super(Badge.class);
    }


    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId) {
        if(groupId !=null || taskPlanId != null || taskId != null )
        {
            Query query = this.entityManager.createQuery("select t from Project as pg join pg.taskplans as tp join tp.tasks as tsk join tsk.badges as t where tp.id = :targetTaskplanId AND tsk.id = :targettaskId AND pg.id =:targetprojectgroupId AND t.id=:targetBadgeId");
            query.setParameter("targetprojectgroupId" , groupId);
            query.setParameter("targetTaskplanId" , taskPlanId);
            query.setParameter("targettaskId" , taskId);
            query.setParameter("targetBadgeId" , badgeId);
            List<Badge> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }



    @Transactional
    public void updateBadge(Badge badge){
        Badge badgeFromDbs = this.getById(badge.getId());
        if (badgeFromDbs != null) {
            badgeFromDbs.setName(badge.getName());
            badgeFromDbs.setDescription(badge.getDescription());
            entityManager.persist(badgeFromDbs);
        }
    }


    @Transactional
    public void deleteBadge(Long badgeId) {
        Badge itemFromDbs = this.getById(badgeId);

        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }
    @Transactional
    public void addBadge(Long taskId,Badge badge){
        if(taskId!=null){

            entityManager.persist(badge);
        }

    }



}

