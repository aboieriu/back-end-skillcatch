package com.service;

import facade.api.IGroupFacade;
import facade.api.ITaskplanFacade;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


public class TaskplanService extends BaseService{

    @Autowired
    ITaskplanFacade taskPlanFacade;

    @Autowired
    IGroupFacade groupFacade;

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.GET)
    @ResponseBody
    public Set<TaskPlan> getAllTaskPlans(@PathVariable("groupId") Long groupId)
    {
        return this.groupFacade.getTaskPlans(groupId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.GET)
    @ResponseBody
    public TaskPlan getTaskPlan(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId)
    {
        return this.taskPlanFacade.getTaskplan(groupId, taskPlanId);
    }

    @Transactional
    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addTaskPlan(@PathVariable("groupId") Long groupId,@RequestBody TaskPlan taskPlanId)
    {
        this.groupFacade.addTaskPlanToGroup(groupId,taskPlanId);
    }

    /*@RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteTaskPlan(@PathVariable("taskPlanId") Long taskPlanId, @PathVariable("groupId") String groupId)
    {
        this.taskPlanFacade.deleteTaskplan(taskPlanId);
    }
*/
    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateTaskPlan(@PathVariable("taskPlanId") Long id, @RequestBody TaskPlan taskPlan) {
        taskPlan.setId(id);


        this.taskPlanFacade.updateTaskplan(taskPlan);
    }

}

