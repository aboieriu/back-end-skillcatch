package facade;
import model.Task;
import model.Taskplan;

import java.util.List;
import java.util.Set;


public interface ITaskplanFacade {

    public void addTaskplan(Taskplan taskplan);
    public List<Taskplan> getAllTaskplan();
    public Taskplan getTaskplanById(Long taskplanId);
    public void deleteTaskplanById(Long taskplanId);
    public void updateTaskplan(Taskplan taskplan);
    public void deleteTaskplan(Long groupId , Long taskplanId);
    public Taskplan getTaskplan(Long groupId,Long taskplanId);
    public void addTaskToTaskPlan(Long taskPlanId , Task task);
    public Set<Task> getTasks(Long taskPlanId);
}