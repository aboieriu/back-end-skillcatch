package  facade;
import dao.IBadgeDao;
import dao.ITaskDao;
import model.Badge;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


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

