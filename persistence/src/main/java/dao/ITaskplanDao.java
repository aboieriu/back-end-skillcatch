package dao;

import model.Task;
import model.Taskplan;

import java.util.Set;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface ITaskplanDao extends IGenericDao<Taskplan> {

    void updateTaskplan(Taskplan taskplan);
    Taskplan getTaskplan(Long groupId , Long taskplanId);
    void deleteTaskplan(Long taskplanId);
    Set<Task> getTasks(Long taskPlanId);
    void addTaskplan(Taskplan taskplan);

}
