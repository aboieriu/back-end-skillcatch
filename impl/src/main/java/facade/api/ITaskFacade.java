package facade.api;
import model.Badge;
import model.Task;
import model.TaskPlan;

import java.util.List;
import java.util.Set;


public interface ITaskFacade {

    void addTask(Long taskPlanId,Task task);
    List<Task> getAllTask();
    Task getTaskById(Long taskId);
    void deleteTask(Long taskId);
    void updateTask(Task task);
    Task getTask(Long groupId , Long taskplanId , Long taskId);
    Task getUserTask(Long userId, Long taskId);
    List<Badge> getBadgeFromTask(Long taskId);
    Set<Badge> getBadges(Long taskId);

    Set<Task> getUserTasks(Long userId);

    Set<TaskPlan> getUserOwnTasksPlans(Long userId);

}
