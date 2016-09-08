package dao.api;

import model.Badge;
import model.Task;
import model.TaskPlan;

import java.util.List;


public interface IBadgeDao extends IGenericDao<Badge> {

    void assignBadgeToTask(Task taskFromDbs);

    void assignBadgeToTaskPlan(TaskPlan recieverTaskPlan);

    List<Badge> getTaskPlanUnAssignedBadges(Long taskPlanId);

    List<Badge> getTaskUnAssignedBadges(Long taskId);
}
