package com.endpoint;

import converter.LoggedUserConverter;
import converter.BadgeConverter;
import converter.TaskConverter;
import com.service.BaseService;
import converter.TaskPlanConverter;
import facade.api.IProjectFacade;
import model.TaskPlan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import view.AssignedProjectView;
import view.BadgeView;
import view.LoggedUserView;
import view.TaskPlanView;
import facade.api.ITaskFacade;
import facade.api.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import view.TaskWithBadgesView;

import java.io.*;
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

    @RequestMapping(value = "/assigned-projects",method = RequestMethod.GET)
    @ResponseBody
    public Set<AssignedProjectView> getAssignedProjects() throws Exception {
        Long userId = this.getLoggedUserId();
        Set<AssignedProjectView> assignedProjectViews = this.projectFacade.getAssignedProjects(userId);
        return assignedProjectViews;
    }

    @RequestMapping(value = "/assigned-projects/{projectId}",method = RequestMethod.GET)
    @ResponseBody
    public AssignedProjectView getAssignedProject(@PathVariable("projectId") Long projectId) throws Exception {
        Long userId = this.getLoggedUserId();
        return this.projectFacade.getAssignedProject(userId, projectId);
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

    @RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public void changeTaskStatus(@PathVariable("taskId") Long id, @RequestBody TaskWithBadgesView userTask) throws Exception{
        Long userId = this.getLoggedUserId();
        this.taskFacade.updateTaskStatus(userId, userTask);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@RequestBody User user) throws Exception {
        this.userFacade.updateUser(user);
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("uploadedFile") MultipartFile uploadedFileRef) throws Exception {
        // Get name of uploaded file.
        String fileName = uploadedFileRef.getOriginalFilename();
        String fileDestination="C:/Work/apache-tomcat-7.0.67/images/";
        File selectedFile = new File(fileDestination + fileName);

        // Path where the uploaded file will be stored.
        String path = fileDestination + fileName;
        uploadedFileRef.transferTo(selectedFile);

        // This buffer will store the data read from 'uploadedFileRef'
        byte[] buffer = new byte[1000];

        // Now create the output file on the server.
        File outputFile = new File(path);

        processUpload(uploadedFileRef, buffer, outputFile);
        return fileName;
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
