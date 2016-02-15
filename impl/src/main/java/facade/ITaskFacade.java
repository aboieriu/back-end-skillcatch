package facade;
import model.Badge;
import model.Task;

import java.util.List;


public interface ITaskFacade {

    public void addTask(Task task);
    public List<Task> getAllTask();
    public Task getTaskById(Long taskId);
    public void deleteTask(Long taskId);
    public void updateTask(Task task);
    public Task getTask(Long groupId , Long taskplanId , Long taskId);
//    public void addBadgeToTask(Long taskId , Badge badge);
}
