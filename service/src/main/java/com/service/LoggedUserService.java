package com.service;

import com.converter.AssignedProjectConverter;
import com.converter.UserBadgesConverter;
import com.converter.UserTasksConverter;
import com.view.AssignedProjectView;
import com.view.UserBadgesView;
import com.view.UserTasks;
import facade.ITaskFacade;
import facade.IUserFacade;
import model.Task;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * Created by aboieriu on 6/20/16.
 */
@Controller
@RequestMapping(value = "/api/loggedUser")
public class LoggedUserService extends BaseService{

    @Autowired
    ITaskFacade taskFacade;

    @Autowired
    private IUserFacade allUsersFacade;

    @Autowired
    IUserFacade userFacade;

    private UserTasksConverter userTasksConverter=new UserTasksConverter();

    private UserBadgesConverter userBadgesConverter=new UserBadgesConverter();

    private AssignedProjectConverter assignedProjectConverter = new AssignedProjectConverter();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public User getLoggedUser() throws Exception{
        Long userId = this.getLoggedUserId();
        User loggedUser = userFacade.getUserById(userId);
        return loggedUser;
    }

    @RequestMapping(value = "/assignedProjects",method = RequestMethod.GET)
    @ResponseBody
    public Set<AssignedProjectView> getAssignedProjects() throws Exception {
        Long userId = this.getLoggedUserId();
        return this.assignedProjectConverter.convert(this.allUsersFacade.getAssignedProjects(userId));
    }

    @RequestMapping(value = "/badges",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<UserBadgesView> getUserBadges() throws Exception{
        Long userId = this.getLoggedUserId();
        return  this.userBadgesConverter.convert(this.allUsersFacade.getUserBadges(userId));

    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<UserTasks> getUserTasks() throws Exception {
        Long userId = this.getLoggedUserId();
        return  this.userTasksConverter.convert(this.allUsersFacade.getUserTasks(userId));
    }

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public void changeTaskStatus(@PathVariable("taskId") Long id, @RequestBody Task userTask) {
        userTask.setId(id);
        this.taskFacade.updateTask(userTask);
    }

    @RequestMapping(value = "/tasks/{taskId}",method = RequestMethod.GET)
    @ResponseBody
    public Task getTask(@PathVariable("taskId") Long taskId) throws Exception {
        Long userId = this.getLoggedUserId();
        return this.taskFacade.getUserTask(userId, taskId);
    }



    public ITaskFacade getTaskFacade() {
        return taskFacade;
    }

    public void setTaskFacade(ITaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    public IUserFacade getAllUsersFacade() {
        return allUsersFacade;
    }

    public void setAllUsersFacade(IUserFacade allUsersFacade) {
        this.allUsersFacade = allUsersFacade;
    }

    public UserTasksConverter getUserTasksConverter() {
        return userTasksConverter;
    }

    public void setUserTasksConverter(UserTasksConverter userTasksConverter) {
        this.userTasksConverter = userTasksConverter;
    }

    public UserBadgesConverter getUserBadgesConverter() {
        return userBadgesConverter;
    }

    public void setUserBadgesConverter(UserBadgesConverter userBadgesConverter) {
        this.userBadgesConverter = userBadgesConverter;
    }

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
