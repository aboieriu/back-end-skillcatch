package facade.api;
import model.Task;
import model.TaskPlan;
import view.TaskWithBadgesView;


import java.util.Set;


public interface ITaskFacade {

    void updateTaskStatus(Long userId, TaskWithBadgesView task);
    Set<TaskPlan> getUserOwnTasksPlans(Long userId);
    Set<TaskWithBadgesView> getAll();
    TaskWithBadgesView getOneTask(Long taskId);
    void updateOneTask(Task task);
    void deleteOne(Long taskId);
    void assignBadgeToTask(Long taskId, Long badgeId);
    void removeBadgeFromTask(Long taskId, Long badgeId);
}
