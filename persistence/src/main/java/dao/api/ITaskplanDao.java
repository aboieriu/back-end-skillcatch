package dao.api;

import model.Task;
import model.TaskPlan;

import java.util.Set;


public interface ITaskplanDao extends IGenericDao<TaskPlan> {

    void updateTaskplan(TaskPlan taskplan);
    TaskPlan getTaskplan(Long groupId , Long taskplanId);
    Set<Task> getTasks(Long taskPlanId);
    void deleteById(Long taskPlanId);


    void removeBadgeFromTaskPlan(Long taskPlanId, Long badgeId);
}
