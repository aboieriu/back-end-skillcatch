package facade.api;
import model.Task;
import model.TaskPlan;

import java.util.List;
import java.util.Set;


public interface ITaskplanFacade {


    public List<TaskPlan> getAllTaskplan();
    public TaskPlan getTaskplanById(Long taskplanId);
    public void deleteTaskplanById(Long taskplanId);
    public void updateTaskplan(TaskPlan taskplan);
    public void deleteTaskplan(Long taskplanId);
    public TaskPlan getTaskplan(Long groupId,Long taskplanId);
    public void addTaskToTaskPlan(Long taskPlanId , Task task);
    
    public Set<Task> getTasks(Long taskPlanId);
}