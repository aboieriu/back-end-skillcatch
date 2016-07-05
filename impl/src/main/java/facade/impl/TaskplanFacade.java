package facade.impl;
import converter.TaskPlanConverter;
import dao.api.ITaskplanDao;
import facade.api.ITaskplanFacade;
import model.Task;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import view.TaskPlanView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Transactional
public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao taskplanDao;

    @Autowired
    private TaskPlanConverter taskPlanConverter;

    public List<TaskPlan> getAllTaskplan(){
        return this.taskplanDao.getAll();
    }

    public TaskPlan getTaskplan(Long groupId , Long taskplanId){
        return this.taskplanDao.getTaskplan(groupId, taskplanId);
    }

    public TaskPlan getTaskplanById(Long taskplanId){
        return this.taskplanDao.getById(taskplanId);
    }

    public void deleteTaskplanById(Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }

    public void updateTaskplan(TaskPlan taskplan){
        this.taskplanDao.updateTaskplan( taskplan);
    }

    public void deleteTaskplan( Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }

    public void addTaskToTaskPlan(Long taskPlanId , Task task){
        TaskPlan targetTaskPlan = this.taskplanDao.getById(taskPlanId);
        targetTaskPlan.getTasks().add(task);
        this.updateTaskplan(targetTaskPlan);
    }

    public Set<Task> getTasks(Long taskPlanId){
        return this.taskplanDao.getTasks(taskPlanId);
    }

    public Set<TaskPlanView> getAll(){
        List<TaskPlan> taskPlans = taskplanDao.getAll();
        return taskPlans.stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());
    }

    public TaskPlanView getOne(Long taskPlanId){
        TaskPlan taskPlan = taskplanDao.getById(taskPlanId);
        return taskPlanConverter.convert(taskPlan);
    }

    public void updateOne(TaskPlan taskPlan) {
        taskplanDao.updateTaskplan(taskPlan);
    }

    public void deleteOne(Long taskPlanId) {
        taskplanDao.deleteTaskplan(taskPlanId);
    }
}
