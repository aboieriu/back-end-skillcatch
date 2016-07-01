package facade.impl;
import dao.api.IBadgeDao;
import facade.api.IBadgeFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BadgeFacade implements IBadgeFacade {

    @Autowired
    private IBadgeDao badgeDao;


    public List<Badge> getAllBadge(){
        return this.badgeDao.getAll();
    }

    public Badge getBadgeById(Long groupId,Long taskPlanId,Long taskId,Long badgeId){
        return this.badgeDao.getBadgeById(groupId, taskPlanId, taskId, badgeId);}



    public void deleteBadge(Long badgeId){
        this.badgeDao.deleteBadge(badgeId);
    }

    public void addBadgeToTask(Long taskId,Badge badge){
        this.badgeDao.addBadge(taskId,badge);


    }




}

