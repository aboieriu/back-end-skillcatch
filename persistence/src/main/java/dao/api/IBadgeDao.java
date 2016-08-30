package dao.api;

import model.Badge;
import model.Task;
import model.TaskPlan;


public interface IBadgeDao extends IGenericDao<Badge> {
    void updateBadge(Badge badge);
    public void deleteBadge(Long badgeId);
   // public Badge getBadgeFromUser(Long groupId,Long userId) ;
    public Badge getBadgeById(Long groupId,Long taskPlanId, Long taskId,Long badgeId);


    void awardBadgeToTask(Task taskFromDbs);

    void awardBadgeToTaskPlan(TaskPlan recieverTaskPlan);
}
