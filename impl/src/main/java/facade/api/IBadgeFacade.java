package facade.api;

import model.Badge;
import view.BadgeView;

import java.util.List;
import java.util.Set;


public interface IBadgeFacade {

    void deleteBadge(Long badgeId);
    Set<BadgeView> getAll();
    BadgeView getOne(Long badgeId);
    void createBadge(Badge badge);
    Set<BadgeView> getTaskPlanUnAssignedBadges(Long taskPlanId);
    Set<BadgeView> getTaskUnAssignedBadges(Long taskId);

}
