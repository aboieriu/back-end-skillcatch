package facade;
import dao.ITaskplanDao;
import model.Task;
import model.Taskplan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao taskplanDao;

    public List<Taskplan> getAllTaskplan(){
        return this.taskplanDao.getAll();
    }
    public Taskplan getTaskplan(Long groupId , Long taskplanId){ return this.taskplanDao.getTaskplan(groupId, taskplanId);}

    public Taskplan getTaskplanById(Long taskplanId){
        return this.taskplanDao.getById(taskplanId);}



    public void deleteTaskplanById(Long taskplanId){
        this.taskplanDao.deleteById(taskplanId);
    }

    public void updateTaskplan(Taskplan taskplan){
        this.taskplanDao.update(taskplan.getId(), taskplan);
    }
    public void deleteTaskplan( Long taskplanId){this.taskplanDao.deleteTaskplan(taskplanId);}


    public void addTaskToTaskPlan(Long taskPlanId , Task task){
        Taskplan targetTaskPlan = this.taskplanDao.getById(taskPlanId);
        targetTaskPlan.getTasks().add(task);
        this.updateTaskplan(targetTaskPlan);

    }

    public Set<Task> getTasks(Long taskPlanId){
        return this.taskplanDao.getTasks(taskPlanId);
    }





}
