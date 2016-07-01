package dao.api;

import model.Task;
import model.TaskPlan;

import java.util.Set;


public interface ITaskplanDao extends IGenericDao<TaskPlan> {

    void updateTaskplan(TaskPlan taskplan);
    TaskPlan getTaskplan(Long groupId , Long taskplanId);
    void deleteTaskplan(Long taskplanId);
    Set<Task> getTasks(Long taskPlanId);


}
