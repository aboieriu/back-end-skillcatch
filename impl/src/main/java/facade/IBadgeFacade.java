package facade;
import model.Badge;
import model.Task;

import java.util.List;
import java.util.Set;


public interface IBadgeFacade {

    public void addBadge(Badge badge);
    public List<Badge> getAllBadge();
    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId);
    public void deleteBadge(Long groupId,Long taskPlanId,Long taskId,Long badgeId);
    public void updateBadge(Badge badge);

   // public Badge getBadgeFromUser(Long groupId,Long userId) ;
    }
