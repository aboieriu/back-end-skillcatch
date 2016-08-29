package facade.impl;
import converter.BadgeConverter;
import dao.api.IBadgeDao;
import facade.api.IBadgeFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class BadgeFacade implements IBadgeFacade {

    @Autowired
    private IBadgeDao badgeDao;
    @Autowired
    private BadgeConverter badgeConverter;


    public List<Badge> getAllBadge(){
        return this.badgeDao.getAll();
    }

    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId){
        return this.badgeDao.getBadgeById(groupId, taskPlanId, taskId, badgeId);}



    public void deleteBadge(Long badgeId){
        this.badgeDao.deleteById(badgeId);
    }

    public void addBadgeToTask(Long taskId,Badge badge){
        this.badgeDao.addBadge(taskId,badge);


    }

    @Override
    public Set<BadgeView> getAll() {
      List<Badge> badges=badgeDao.getAll();
        return badges.stream().map(badge -> badgeConverter.convert(badge)).collect(Collectors.toSet());
    }

    @Override
    public BadgeView getOne(Long badgeId) {
        Badge badge=badgeDao.getById(badgeId);
        return badgeConverter.convert(badge);
    }

    @Override
    public void createBadge(Badge badge) {
        this.badgeDao.add(badge);
    }


}

