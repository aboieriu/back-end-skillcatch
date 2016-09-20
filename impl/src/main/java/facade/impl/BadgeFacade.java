package facade.impl;
import converter.BadgeConverter;
import dao.api.IBadgeDao;
import dao.api.ITaskDao;
import facade.api.IBadgeFacade;
import model.Badge;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import view.BadgeView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class BadgeFacade implements IBadgeFacade {

    @Autowired
    private IBadgeDao badgeDao;
    @Autowired
    private BadgeConverter badgeConverter;

    public void deleteBadge(Long badgeId){
        this.badgeDao.deleteById(badgeId);
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

    @Override
    public Set<BadgeView> getTaskPlanUnAssignedBadges(Long taskPlanId) {
        List<Badge> badges=this.badgeDao.getTaskPlanUnAssignedBadges(taskPlanId);
        return badges.stream().map(badge -> badgeConverter.convert(badge)).collect(Collectors.toSet());
    }

    @Override
    public Set<BadgeView> getTaskUnAssignedBadges(Long taskId) {
        List<Badge> badgeSet=this.badgeDao.getTaskUnAssignedBadges(taskId);
        return badgeSet.stream().map(badge -> badgeConverter.convert(badge)).collect(Collectors.toSet());
    }

    @Override
    public void updateOne(Badge badge) {
        this.badgeDao.updateOne(badge);
    }


}

