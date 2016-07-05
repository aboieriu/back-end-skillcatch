package com.endpoint;

import facade.api.ITaskplanFacade;
import model.Project;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import view.ProjectView;
import view.TaskPlanView;

import java.util.Set;

/**
 * Created by aboieriu on 7/4/16.
 */
@Controller
@RequestMapping("/api/taskplans")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class TaskplanResource {

    @Autowired
    private ITaskplanFacade taskplanFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<TaskPlanView> getProjects() throws Exception {
        return this.taskplanFacade.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TaskPlanView getProject(@PathVariable("id") Long projectId) throws Exception {
        return this.taskplanFacade.getOne(projectId);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateProject(@RequestBody TaskPlan taskPlan) throws Exception {
        this.taskplanFacade.updateOne(taskPlan);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProject(@PathVariable("id") Long taskPlanId) throws Exception {
        this.taskplanFacade.deleteOne(taskPlanId);
    }

    public ITaskplanFacade getTaskplanFacade() {
        return taskplanFacade;
    }

    public void setTaskplanFacade(ITaskplanFacade taskplanFacade) {
        this.taskplanFacade = taskplanFacade;
    }
}
