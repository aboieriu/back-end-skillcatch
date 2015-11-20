package facade;
import model.Badge;
import model.Group;

import java.util.List;


public interface IBadgeFacade {

    public void addBadge(Badge badge);
    public List<Badge> getAllBadge();
    public Badge getBadgeById(Long badgeId);
    public void deleteBadge(Long badgeId);
    public void updateBadge(Badge badge);
}
