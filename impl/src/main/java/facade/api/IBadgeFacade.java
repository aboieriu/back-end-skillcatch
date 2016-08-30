package facade.api;

import model.Badge;
import view.BadgeView;

import java.util.List;
import java.util.Set;


public interface IBadgeFacade {


   List<Badge> getAllBadge();
    Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId);
    void deleteBadge(Long badgeId);

    Set<BadgeView> getAll();

    BadgeView getOne(Long badgeId);

    void createBadge(Badge badge);



}
