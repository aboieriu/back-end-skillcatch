package  facade;
import dao.IBadgeDao;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BadgeFacade implements IBadgeFacade {

    @Autowired
    private IBadgeDao badgeDao;

    public List<Badge> getAllBadge(){
        return this.badgeDao.getAll();
    }

    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId){
        return this.badgeDao.getBadgeById(groupId, taskPlanId, taskId, badgeId);}

    public void addBadge(Badge badge){
        this.badgeDao.add(badge);
    }

    public void deleteBadge(Long badgeId,Long taskplanId, Long taskId , Long groupId){
        this.badgeDao.deleteBadge(badgeId, taskplanId, taskId, groupId);
    }

    public void updateBadge(Badge badge){
        this.badgeDao.updateBadge(badge);
    }

    /*public Badge getBadgeFromUser(Long groupId,Long userId) {
        return this.badgeDao.getBadgeFromUser(groupId, userId);}
*/
}

