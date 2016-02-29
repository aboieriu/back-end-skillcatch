package facade;
import dao.ITaskDao;
import facade.ITaskFacade;
import model.Badge;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


public class TaskFacade implements ITaskFacade {

    @Autowired
    private ITaskDao taskDao;

    public List<Task> getAllTask(){
        return this.taskDao.getAll();
    }

    public Task getTask(Long groupId , Long taskplanId, Long taskId){
        return this.taskDao.getTask(groupId, taskplanId, taskId)
    ;}


    public Task getTaskById(Long taskId){
        return this.taskDao.getById(taskId);}

    public void addTask(Long taskPlanId,Task task){
        this.taskDao.add(task);
    }

    public void deleteTask(Long groupId){
        this.taskDao.deleteById(groupId);
    }

    public void updateTask(Task task){
        this.taskDao.updateTask(task);
    }

/*
    public void addBadgeToTask(Long taskId , Badge badge){
        Task targetTask = this.taskDao.getById(taskId);
        targetTask.getBadges().add(badge);
        this.taskDao.updateTask(targetTask);

    }*/
public Set<Badge> getBadgeFromTask(Long taskId){
    return this.taskDao.getBadgeFromTask(taskId);
}
}
