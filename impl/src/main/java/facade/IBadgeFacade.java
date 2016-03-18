package facade;

import model.Badge;

import java.util.List;


public interface IBadgeFacade {


    List<Badge> getAllBadge();
    Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId);
    void deleteBadge(Long badgeId);
    void addBadgeToTask(Long taskId,Badge badge);



    }
