package facade.api;

import model.Badge;

import java.util.List;
import java.util.Set;


public interface IBadgeFacade {


   List<Badge> getAllBadge();
    Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId);
    void deleteBadge(Long badgeId);
    void addBadgeToTask(Long taskId,Badge badge);



    }
