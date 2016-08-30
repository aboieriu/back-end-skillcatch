package facade.impl;
import converter.TaskConverter;
import dao.api.IBadgeDao;
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
    @Autowired
    private IBadgeDao badgeDao;
    @Autowired
    private TaskConverter taskConverter;

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
    public void addTask(Task task){
        this.taskDao.add(task);
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

    @Override
    public Set<TaskWithBadgesView> getAll() {
        List<Task> tasks=taskDao.getAll();
        return tasks.stream().map(task -> taskConverter.convertWithBadges(task)).collect(Collectors.toSet());
    }

    @Override
    public TaskWithBadgesView getOneTask(Long taskId) {
        Task task=taskDao.getById(taskId);
        return taskConverter.convertWithBadges(task);
    }

    @Override
    public void updateOneTask(Task task) {
        Task taskFromDbs=this.taskDao.getById(task.getId());
        if(taskFromDbs!=null){
            taskFromDbs.setName(task.getName());
            taskFromDbs.setDescription(task.getDescription());
            taskFromDbs.setStatus(task.getStatus());
                if(task.getBadges()!=null){
                    task.getBadges().stream().forEach(badge -> {
                        Badge badgeToAdd=badgeDao.getById(badge.getId());
                        if(badgeToAdd==null){
                            taskFromDbs.getBadges().add(badge);
                        }
                    });
                }
            taskDao.updateTask(taskFromDbs);
        }
    }

    @Override
    public void deleteOne(Long taskId) {
        this.taskDao.deleteById(taskId);
    }

    @Override
    public void awardBadgeToTask(Long taskId, Long badgeId) {
        Task taskFromDbs=this.taskDao.getById(taskId);
        if(taskFromDbs!=null){
            Badge badgeToAward=badgeDao.getById(badgeId);
            taskFromDbs.getBadges().add(badgeToAward);
            this.badgeDao.awardBadgeToTask(taskFromDbs);
        }

    }

    @Override
    public void removeBadgeFromTask(Long taskId, Long badgeId) {
        this.taskDao.removeBadgeFromTask(taskId,badgeId);
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
