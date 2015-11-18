import model.Badge;
import model.Group;


public interface IBadgeFacade extends IGenericFacade<Badge> {

    void updateBadge(Badge badge);
}