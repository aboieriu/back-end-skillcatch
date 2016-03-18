package dao;

import model.Badge;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface IBadgeDao extends IGenericDao<Badge> {
    void updateBadge(Badge badge);
    public void deleteBadge(Long badgeId);
   // public Badge getBadgeFromUser(Long groupId,Long userId) ;
    public Badge getBadgeById(Long groupId,Long taskPlanId, Long taskId,Long badgeId);
    void addBadge(Long taskId,Badge badge);

}
