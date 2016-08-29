package facade.impl;
import converter.ProjectConverter;
import converter.TaskConverter;
import converter.TaskPlanConverter;
import dao.api.IProjectDao;
import dao.api.ITaskDao;
import dao.api.ITaskplanDao;
import facade.api.IProjectFacade;
import facade.api.ITaskplanFacade;
import model.Project;
import model.Task;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import view.ProjectView;
import view.TaskPlanView;
import view.TaskView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Transactional
public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao taskplanDao;
    @Autowired
    private ITaskDao taskDao;
    @Autowired
    private IProjectDao projectDao;
    @Autowired
    private TaskPlanConverter taskPlanConverter;
    @Autowired
    private ProjectConverter projectConverter;

    public List<TaskPlan> getAllTaskplan(){
        return this.taskplanDao.getAll();
    }

    public TaskPlan getTaskplan(Long groupId , Long taskplanId){
        return this.taskplanDao.getTaskplan(groupId, taskplanId);
    }

    public TaskPlan getTaskplanById(Long taskplanId){
        return this.taskplanDao.getById(taskplanId);
    }

   /* public void deleteTaskplanById(Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }*/

    public void updateTaskplan(TaskPlan taskplan){
        this.taskplanDao.updateTaskplan( taskplan);
    }


/*public void deleteTaskplan( Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }*/


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
        TaskPlan taskplanFromDbs=this.taskplanDao.getById(taskPlan.getId());
        if(taskplanFromDbs!=null){
            taskplanFromDbs.setName(taskPlan.getName());
            taskplanFromDbs.setDescription(taskPlan.getDescription());
            if(taskPlan.getTasks()!=null){
                taskPlan.getTasks().stream().forEach(task->{
                    Task taskToAdd=taskDao.getById(task.getId());
                    if(taskToAdd == null){
                        taskplanFromDbs.getTasks().add(task);
                    }

                });
            }
            taskplanDao.updateTaskplan(taskplanFromDbs);
        }
    }

    public void deleteOne(Long taskPlanId) {
        taskplanDao.deleteById(taskPlanId);
    }

    @Override
    public void addTaskToTaskPlan(Long taskPlanId, Task task) {

    }

}
