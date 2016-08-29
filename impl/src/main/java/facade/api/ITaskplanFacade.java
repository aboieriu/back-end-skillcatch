package facade.api;
import model.Task;
import model.TaskPlan;
import view.TaskPlanView;
import view.TaskView;

import java.util.List;
import java.util.Set;


public interface ITaskplanFacade {


    List<TaskPlan> getAllTaskplan();
    TaskPlan getTaskplanById(Long taskplanId);
   /* void deleteTaskplanById(Long taskplanId);*/
    void updateTaskplan(TaskPlan taskplan);
   /* void deleteTaskplan(Long taskplanId);*/
    TaskPlan getTaskplan(Long groupId,Long taskplanId);
    Set<Task> getTasks(Long taskPlanId);
    Set<TaskPlanView> getAll();
    TaskPlanView getOne(Long id);
    void updateOne(TaskPlan taskPlan);
    void deleteOne(Long taskPlanId);

    void addTaskToTaskPlan(Long taskPlanId, Task task);

}