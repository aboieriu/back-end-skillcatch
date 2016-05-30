package dao;

import model.Badge;
import model.Task;

import java.util.List;


public interface ITaskDao extends IGenericDao<Task>  {

    public Task getTask(Long groupId , Long taskplanId, Long taskId);
    void updateTask(Task task);
    public List<Badge> getBadgeFromTask(Long taskId);
    public void add(Task task);



}
