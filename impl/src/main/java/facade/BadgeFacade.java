import model.Badge;
import model.Group;
import org.springframework.transaction.annotation.Transactional;
import dao.IGenericDao;


public class BadgeFacade extends GenericFacade<Badge> implements IBadgeFacade {
    public BadgeFacade() {
        super(Badge.class);
    }

    @Autowired
    private IGenericDao item;

    public IGenericDao getItem() {
        return item;
    }


    public void setItem(IGenericDao item) {
        this.item = item;
    }

    @Transactional
    public void updateBadge(Badge badge){
        Badge badgeFromDbs = this.getById(badge.getBadgeId());
        if (badgeFromDbs != null) {
            badgeFromDbs.setName(badge.getName());
            badgeFromDbs.setDescription(badge.getDescription());
            item.add(badgeFromDbs);
        }
    }

}
