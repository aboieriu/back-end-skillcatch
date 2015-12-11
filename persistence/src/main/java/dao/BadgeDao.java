package dao;

import model.Badge;
import model.Group;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class BadgeDao extends GenericDao<Badge> implements IBadgeDao {
    public BadgeDao() {
        super(Badge.class);
    }

    @Transactional
    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId) {
        if(groupId !=null || taskPlanId != null || taskId != null || badgeId != null)
        {
            Query query = this.entityManager.createQuery("from Badge WHERE groupId = :targetgroupId AND taskPlanId = :targetTaskPlanId AND taskId = :targetTaskId AND badgeId = :targetBadgeId");
            query.setParameter("targetgroupId" , groupId);
            query.setParameter("targetTaskPlanId" , taskPlanId);
            query.setParameter("targetTaskId" , taskId);
            query.setParameter("targetBadgeId" , badgeId);
            List<Badge> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

    @Transactional
    public Badge getBadgeFromUser(Long groupId,Long userId) {
        if(groupId !=null || userId != null )
        {
            Query query = this.entityManager.createQuery("from Badge WHERE groupId = :targetgroupId AND userId = :targetUserId ");
            query.setParameter("targetgroupId" , groupId);
            query.setParameter("targetUserId" , userId);
            List<Badge> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

    @Transactional
    public void updateBadge(Badge badge){
        Badge badgeFromDbs = this.getById(badge.getBadgeId());
        if (badgeFromDbs != null) {
            badgeFromDbs.setName(badge.getName());
            badgeFromDbs.setDescription(badge.getDescription());
            entityManager.persist(badgeFromDbs);
        }
    }

    @Transactional
    public void deleteBadge(Long groupId , Long taskPlanId,Long taskId , Long badgeId) {
        Badge itemFromDbs = this.getBadgeById(groupId, taskPlanId, taskId, badgeId);

        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

}
