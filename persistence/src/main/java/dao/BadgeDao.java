package dao;

import model.Badge;
import model.Group;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class BadgeDao extends GenericDao<Badge> implements IBadgeDao {
    public BadgeDao() {
        super(Badge.class);
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
}
