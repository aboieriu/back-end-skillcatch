package facade.impl;
import dao.api.ITaskDao;
import dao.api.IUserDao;
import domain.TaskStatus;
import facade.api.ITaskFacade;
import model.Badge;
import model.Task;
import model.TaskPlan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.TaskView;
import view.TaskWithBadgesView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
    public void updateTaskStatus(Long userId, TaskWithBadgesView task){
        User user = userDao.getById(userId);
        if (task != null && TaskStatus.contains(task.getStatus())) {
            if (user != null) {
                Task targetUserTask = getUsersTask(user, task.getId());
                if (targetUserTask != null) {
                    targetUserTask.setStatus(TaskStatus.valueOf(task.getStatus()).name());
                    this.taskDao.updateTask(targetUserTask);
                }
            }
        }
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
        User user = userDao.getById(userId);
        if (user != null) {
            Set<Task> userTasks = new HashSet<>();
            user.getTaskPlans().stream().forEach(taskPlan -> {
                userTasks.addAll(taskPlan.getTasks());
            });
            user.getProjects().stream().forEach(project -> {
                project.getTaskPlans().stream().forEach(taskPlan -> {
                    userTasks.addAll(taskPlan.getTasks());
                });

            });
            return userTasks;
        }
        return new HashSet<>();
    }

    @Override
    public Set<TaskPlan> getUserOwnTasksPlans(Long userId) {
        User user = this.userDao.getById(userId);
        if (user != null) {
            return user.getTaskPlans();
        }
        return new HashSet<>();
    }

    private Set<Task> getUsersTasks(User user) {
        Set<Task> userTasks = new HashSet<>();
        user.getTaskPlans().stream().forEach(taskPlan -> {
            userTasks.addAll(taskPlan.getTasks());
        });
        user.getProjects().stream().forEach(project -> {
            project.getTaskPlans().stream().forEach(taskPlan -> {
                userTasks.addAll(taskPlan.getTasks());
            });
        });
        return userTasks;
    }

    private Task getUsersTask(User user, Long taskId) {
        Set<Task> userTasks = getUsersTasks(user);
        Set<Task> targetUserTask = userTasks.stream().filter(task -> taskId.equals(task.getId())).collect(Collectors.toSet());
        return targetUserTask.isEmpty() ? null : targetUserTask.iterator().next();
    }
}
