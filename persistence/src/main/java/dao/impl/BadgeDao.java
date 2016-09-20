package dao.impl;

import dao.api.IBadgeDao;
import model.Badge;
import model.Task;
import model.TaskPlan;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeDao extends GenericDao<Badge> implements IBadgeDao {

    private final String BADGE_IMAGE_LOCATION="C:/Work/apache-tomcat-7.0.67/images/badges/";

    public BadgeDao() {
        super(Badge.class);
    }


    @Transactional
    @Override
    public void assignBadgeToTask(Task taskFromDbs) {
        taskFromDbs.setBadges(taskFromDbs.getBadges());
        entityManager.merge(taskFromDbs);
        entityManager.flush();
        entityManager.clear();
    }
    @Transactional
    @Override
    public void assignBadgeToTaskPlan(TaskPlan recieverTaskPlan) {
        recieverTaskPlan.setBadges(recieverTaskPlan.getBadges());
        entityManager.merge(recieverTaskPlan);
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public List<Badge> getTaskPlanUnAssignedBadges(Long taskPlanId) {
        Query query=this.entityManager.createQuery("SELECT badges FROM Badge badges, TaskPlan taskPlans JOIN taskPlans.badges AS taskPlanBadges WHERE badges.id NOT IN (SELECT badges.id FROM Badge badges,TaskPlan taskPlans JOIN taskPlans.badges AS taskPlanBadge WHERE badges.id=taskPlanBadge.id AND taskPlans.id=:targetTaskPlanId) GROUP BY badges.id");
        query.setParameter("targetTaskPlanId",taskPlanId);
        List<Badge> result=query.getResultList();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Badge> getTaskUnAssignedBadges(Long taskId) {
        Query query=this.entityManager.createQuery("SELECT badges FROM Badge badges,Task tasks JOIN tasks.badges AS taskBadges WHERE badges.id NOT IN(SELECT badges.id FROM Badge badges, Task tasks JOIN tasks.badges AS taskBadge WHERE badges.id=taskBadge.id AND tasks.id=:targetTaskId) GROUP BY badges.id");
        query.setParameter("targetTaskId",taskId);
        List<Badge> result=query.getResultList();
        if(!result.isEmpty()){
            return result;
        }
        return new ArrayList<>();
    }

    @Transactional
    @Override
    public void updateOne(Badge badge) {
        Badge badgeFromDbs=this.getById(badge.getId());
        if(badgeFromDbs!=null){
            if(!Objects.equals(badge.getName(), "") && badge.getName() !=null){
                badgeFromDbs.setName(badge.getName());
            }
            if(!Objects.equals(badge.getDescription(), "") && badge.getDescription() !=null){
                badgeFromDbs.setDescription(badge.getDescription());
            }
            if(badge.getPoints() !=null){
                badgeFromDbs.setPoints(badge.getPoints());
            }
            if(!Objects.equals(badge.getImage(), "") && badge.getImage() !=null){
                String badgePicture=badgeFromDbs.getImage();
                boolean result=replacePicture(badgePicture,BADGE_IMAGE_LOCATION);
                if(result){
                    badgeFromDbs.setImage(badge.getImage());
                }

            }
            entityManager.merge(badgeFromDbs);
            entityManager.flush();
        }
    }


}

