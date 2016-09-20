package facade.impl;

import converter.UserConverter;
import dao.api.IProjectDao;
import dao.api.ITaskplanDao;
import dao.api.IUserDao;
import facade.api.IUserFacade;
import model.*;


import org.springframework.beans.factory.annotation.Autowired;
import view.UserView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserFacade implements IUserFacade {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IProjectDao projectDao;

    @Autowired
    private ITaskplanDao taskplanDao;

    @Override
    public Set<UserView> getAll() {
        return this.userDao.getAll().stream().map(user -> userConverter.convert(user)).collect(Collectors.toSet());
    }

    @Override
    public UserView getOne(Long userId) {
        User user = userDao.getById(userId);
        return userConverter.convert(user);
    }

    @Override
    public void assignUserToProject(Long userId, Long projectId) {
        User userFromDbs = this.userDao.getById(userId);
        if (userFromDbs != null) {
            Project projectToAssign = projectDao.getById(projectId);
            userFromDbs.getProjects().add(projectToAssign);
            this.userDao.assignUserToProject(userFromDbs);
        }
    }

    @Override
    public Set<UserView> getProjectUnAssignedUsers(Long projectId) {
        List<User> users=this.userDao.getProjectUnAssignedUsers(projectId);
        return users.stream().map(user -> userConverter.convert(user)).collect(Collectors.toSet());
    }

    @Override
    public void removeTaskPlanFromUser(Long userId, Long taskPlanId) {
        this.userDao.removeTaskPlanFromUser(userId,taskPlanId);
    }

    @Override
    public void assignTaskPlanToUser(Long userId, Long taskPlanId) {
        User userFromDbs=this.userDao.getById(userId);
        if(userFromDbs!=null){
            TaskPlan taskPlanToAssign=taskplanDao.getById(taskPlanId);
            userFromDbs.getTaskPlans().add(taskPlanToAssign);
            this.userDao.assignTaskPlanToUser(userFromDbs);
        }
    }

    @Override
    public Set<TaskPlan> getUserTaskPlans(Long userId) {
        User userFromDbs=this.userDao.getById(userId);
        if(userFromDbs!=null){
            Set<TaskPlan> taskPlans=userFromDbs.getTaskPlans();
            Set<TaskPlan> projectTaskPlans=new HashSet<>();
            userFromDbs.getProjects().stream().forEach(project ->
            projectTaskPlans.addAll(project.getTaskPlans()));
            taskPlans.addAll(projectTaskPlans);
            return taskPlans;
        }
        return new HashSet<>();
    }

    @Override
    public User getUserById(Long userId) {
        return this.userDao.getById(userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        this.userDao.deleteUserById(userId);
    }

    @Override
    public void addUser(User user) {
        this.userDao.add(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    public User findByUserName(String username) {

        return this.userDao.findByUserName(username);
    }

    @Override
    public Set<Badge> getUserBadges(Long userId) {
        return this.userDao.getUserBadges(userId);
    }

}

