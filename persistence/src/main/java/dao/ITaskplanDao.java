package dao;

import model.Task;
import model.Taskplan;

import java.util.Set;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface ITaskplanDao extends IGenericDao<Taskplan> {

    void updateTaskplan(Taskplan taskplan);
    public Taskplan getTaskplan(Long groupId , Long taskplanId);
    public void deleteTaskplan(Long groupId , Long taskplanId);
    public Set<Task> getTasks(Long taskPlanId);
}
