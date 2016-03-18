package dao;

import model.Badge;
import model.Task;

import java.util.List;
import java.util.Set;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface ITaskDao extends IGenericDao<Task>  {

    public Task getTask(Long groupId , Long taskplanId, Long taskId);
    void updateTask(Task task);
    public List<Badge> getBadgeFromTask(Long taskId);
    public void add(Task task);



}
