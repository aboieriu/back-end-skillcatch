package com.endpoint;

import facade.api.ITaskplanFacade;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Set<TaskPlanView> getTaskPlans() throws Exception {
        return this.taskplanFacade.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskPlanView getTaskPlan(@PathVariable("id") Long taskPlanId) throws Exception {
        return this.taskplanFacade.getOne(taskPlanId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTaskPlan(@RequestBody TaskPlan taskPlan) throws Exception {
        this.taskplanFacade.updateOne(taskPlan);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTaskPlan(@PathVariable("id") Long taskPlanId) throws Exception {
        this.taskplanFacade.deleteOne(taskPlanId);
    }

    @RequestMapping(value = "/{taskPlanId}/removeBadgeFromTaskPlan/{badgeId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void removeBadgeFromTaskPlan(@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("badgeId") Long badgeId) throws Exception {
        this.taskplanFacade.removeBadgeFromTaskPlan(taskPlanId,badgeId);
    }

    @RequestMapping(value = "/{taskPlanId}/assignBadge/{badgeId}",method = RequestMethod.PUT)
    @ResponseBody
    public void assignBadgeToTask(@PathVariable("taskPlanId")Long taskPlanId,@PathVariable("badgeId") Long badgeId){
        this.taskplanFacade.assignBadgeToTaskPlan(taskPlanId,badgeId);
    }



    public ITaskplanFacade getTaskplanFacade() {
        return taskplanFacade;
    }

    public void setTaskplanFacade(ITaskplanFacade taskplanFacade) {
        this.taskplanFacade = taskplanFacade;
    }
}
