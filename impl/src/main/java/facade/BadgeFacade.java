package  facade;
import dao.IBadgeDao;
import dao.IGroupDao;
import model.Badge;
import model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dao.IGenericDao;

import java.util.List;


public class BadgeFacade implements IBadgeFacade {

    @Autowired
    private IBadgeDao badgeDao;

    public List<Badge> getAllBadge(){
        return this.badgeDao.getAll();
    }

    public Badge getBadgeById(Long badgeId){
        return this.badgeDao.getById(badgeId);}

    public void addBadge(Badge badge){
        this.badgeDao.add(badge);
    }

    public void deleteBadge(Long badgeId){
        this.badgeDao.deleteById(badgeId);
    }

    public void updateBadge(Badge badge){
        this.badgeDao.updateBadge(badge);
    }
}
