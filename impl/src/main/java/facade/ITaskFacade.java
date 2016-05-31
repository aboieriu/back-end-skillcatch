package facade;
import model.Badge;
import model.Task;

import java.util.List;
import java.util.Set;


public interface ITaskFacade {

    public void addTask(Long taskPlanId,Task task);
    public List<Task> getAllTask();
    public Task getTaskById(Long taskId);
    public void deleteTask(Long taskId);
    public void updateTask(Task task);
    public Task getTask(Long groupId , Long taskplanId , Long taskId);
    public List<Badge> getBadgeFromTask(Long taskId);
    public Set<Badge> getBadges(Long taskId);


}
