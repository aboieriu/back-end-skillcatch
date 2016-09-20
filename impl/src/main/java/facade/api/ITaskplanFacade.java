package facade.api;
import model.Task;
import model.TaskPlan;
import view.TaskPlanView;
import view.TaskView;

import java.util.List;
import java.util.Set;


public interface ITaskplanFacade {

    Set<TaskPlanView> getAll();
    TaskPlanView getOne(Long id);
    void updateOne(TaskPlan taskPlan);
    void deleteOne(Long taskPlanId);
    void assignBadgeToTaskPlan(Long taskPlanId, Long badgeId);
    void removeBadgeFromTaskPlan(Long taskPlanId, Long badgeId);
    Set<TaskPlanView> getProjectUnAssignedTaskPlans(Long userId);
    void createOne(TaskPlan taskPlan);
}