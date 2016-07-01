package com.endpoint;

import converter.LoggedUserConverter;
import converter.BadgeConverter;
import converter.TaskConverter;
import com.service.BaseService;
import converter.TaskPlanConverter;
import facade.api.IProjectFacade;
import model.TaskPlan;
import view.AssignedProjectView;
import view.BadgeView;
import view.LoggedUserView;
import view.TaskPlanView;
import view.TaskView;
import facade.api.ITaskFacade;
import facade.api.IUserFacade;
import model.Task;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import view.TaskWithBadgesView;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/20/16.
 */
@Controller
@RequestMapping(value = "/api/loggedUser")
public class LoggedUserService extends BaseService {

    @Autowired
    ITaskFacade taskFacade;

    @Autowired
    private IProjectFacade projectFacade;

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private TaskConverter userTasksConverter;

    @Autowired
    private BadgeConverter userBadgesConverter;

    @Autowired
    private LoggedUserConverter loggedUserConverter;

    @Autowired
    private TaskPlanConverter taskPlanConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public LoggedUserView getLoggedUser() throws Exception{
        Long userId = this.getLoggedUserId();
        User loggedUser = userFacade.getUserById(userId);
        return loggedUserConverter.convert(loggedUser);
    }

    @RequestMapping(value = "/assignedProjects",method = RequestMethod.GET)
    @ResponseBody
    public Set<AssignedProjectView> getAssignedProjects() throws Exception {
        Long userId = this.getLoggedUserId();
        Set<AssignedProjectView> assignedProjectViews = this.projectFacade.getAssignedProjects(userId);
        return assignedProjectViews;
    }

    @RequestMapping(value = "/badges",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<BadgeView> getUserBadges() throws Exception{
        Long userId = this.getLoggedUserId();
        return  this.userBadgesConverter.convert(this.userFacade.getUserBadges(userId));
    }

    @RequestMapping(value = "/own-tasks-plans",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<TaskPlanView> getUserOwnTasks() throws Exception {
        Long userId = this.getLoggedUserId();
        Set<TaskPlan> taskPlans = this.taskFacade.getUserOwnTasksPlans(userId);
        return taskPlans.stream().map(taskPlan -> this.taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<TaskView> getUserTasks() throws Exception {
        Long userId = this.getLoggedUserId();
        return  this.userTasksConverter.convert(this.taskFacade.getUserTasks(userId));
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

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public TaskConverter getUserTasksConverter() {
        return userTasksConverter;
    }

    public void setUserTasksConverter(TaskConverter userTasksConverter) {
        this.userTasksConverter = userTasksConverter;
    }

    public BadgeConverter getUserBadgesConverter() {
        return userBadgesConverter;
    }

    public void setUserBadgesConverter(BadgeConverter userBadgesConverter) {
        this.userBadgesConverter = userBadgesConverter;
    }

    public LoggedUserConverter getLoggedUserConverter() {
        return loggedUserConverter;
    }

    public void setLoggedUserConverter(LoggedUserConverter loggedUserConverter) {
        this.loggedUserConverter = loggedUserConverter;
    }

    public IProjectFacade getProjectFacade() {
        return projectFacade;
    }

    public void setProjectFacade(IProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }
}
