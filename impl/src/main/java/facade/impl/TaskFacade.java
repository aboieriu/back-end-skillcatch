package facade.impl;
import dao.api.ITaskDao;
import dao.api.IUserDao;
import facade.api.ITaskFacade;
import model.Badge;
import model.Task;
import model.TaskPlan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public  class TaskFacade implements ITaskFacade {

    @Autowired
    private ITaskDao taskDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public List<Task> getAllTask(){
        return this.taskDao.getAll();
    }

    @Override
    public Task getTask(Long groupId , Long taskplanId, Long taskId){
        return this.taskDao.getTask(groupId, taskplanId, taskId);
    }

    @Override
    public Task getUserTask(Long userId,Long taskId){
        return this.taskDao.getUserTask(userId, taskId);
    }

    @Override
    public Task getTaskById(Long taskId){
        return this.taskDao.getById(taskId);}

    @Override
    public void addTask(Long taskPlanId,Task task){
        this.taskDao.add(task);
    }

    @Override
    public void deleteTask(Long groupId){
        this.taskDao.deleteById(groupId);
    }

    @Override
    public void updateTask(Task task){
        this.taskDao.updateTask(task);
    }

    @Override
    public List<Badge> getBadgeFromTask(Long taskId){
        return this.taskDao.getBadgeFromTask(taskId);
    }

    @Override
    public Set<Badge> getBadges(Long taskId) {
        return null;
    }

    @Override
    public Set<Task> getUserTasks(Long userId) {
        return this.userDao.getUserTasks(userId);
    }

    @Override
    public Set<TaskPlan> getUserOwnTasksPlans(Long userId) {
        User user = this.userDao.getById(userId);
        if (user != null) {
            return user.getTaskPlans();
        }
        return new HashSet<>();
    }
}
