package facade.impl;
import dao.api.ITaskplanDao;
import facade.api.ITaskplanFacade;
import model.Task;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao taskplanDao;

    public List<TaskPlan> getAllTaskplan(){
        return this.taskplanDao.getAll();
    }
    public TaskPlan getTaskplan(Long groupId , Long taskplanId){ return this.taskplanDao.getTaskplan(groupId, taskplanId);}

    public TaskPlan getTaskplanById(Long taskplanId){
        return this.taskplanDao.getById(taskplanId);}



    public void deleteTaskplanById(Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }

    public void updateTaskplan(TaskPlan taskplan){
        this.taskplanDao.updateTaskplan( taskplan);
    }
    public void deleteTaskplan( Long taskplanId){this.taskplanDao.deleteById(taskplanId);}


    public void addTaskToTaskPlan(Long taskPlanId , Task task){
        TaskPlan targetTaskPlan = this.taskplanDao.getById(taskPlanId);
        targetTaskPlan.getTasks().add(task);
        this.updateTaskplan(targetTaskPlan);

    }

    public Set<Task> getTasks(Long taskPlanId){
        return this.taskplanDao.getTasks(taskPlanId);
    }





}
