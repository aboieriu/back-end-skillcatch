package facade.api;
import model.Badge;
import model.Task;
import model.TaskPlan;
import view.TaskView;
import view.TaskWithBadgesView;

import java.util.List;
import java.util.Set;


public interface ITaskFacade {

    void addTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long taskId);
    /*void deleteTask(Long taskId);*/
    void updateTaskStatus(Long userId, TaskWithBadgesView task);
    Task getTask(Long groupId , Long taskplanId , Long taskId);
    Task getUserTask(Long userId, Long taskId);
    List<Badge> getBadgeFromTask(Long taskId);
    Set<Badge> getBadges(Long taskId);

    Set<Task> getUserTasks(Long userId);

    Set<TaskPlan> getUserOwnTasksPlans(Long userId);

    Set<TaskWithBadgesView> getAll();

    TaskWithBadgesView getOneTask(Long taskId);

    void updateOneTask(Task task);

    void deleteOne(Long taskId);


    void awardBadgeToTask(Long taskId, Long badgeId);

    void removeBadgeFromTask(Long taskId, Long badgeId);
}
