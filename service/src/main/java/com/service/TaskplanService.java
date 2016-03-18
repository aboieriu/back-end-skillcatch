package com.service;

import facade.IGroupFacade;
import facade.ITaskplanFacade;
import model.Taskplan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Controller
public class TaskplanService {

    @Autowired
    ITaskplanFacade taskPlanFacade;
    @Autowired
    IGroupFacade groupFacade;

    public ITaskplanFacade getTaskPlanFacade() {
        return taskPlanFacade;
    }

    public void setTaskPlanFacade(ITaskplanFacade taskPlanFacade) {
        this.taskPlanFacade = taskPlanFacade;
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.GET)
    @ResponseBody
    public Set<Taskplan> getAllTaskPlans(@PathVariable("groupId") Long groupId)
    {
        return this.groupFacade.getTaskPlans(groupId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.GET)
    @ResponseBody
    public Taskplan getTaskPlan(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId)
    {
        return this.taskPlanFacade.getTaskplan(groupId, taskPlanId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.POST)
    @ResponseBody
    public void addTaskPlan(@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlanId)
    {
        this.groupFacade.addTaskPlanToGroup(groupId,taskPlanId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTaskPlan(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId)
    {
        this.taskPlanFacade.deleteTaskplan(groupId, taskPlanId);
    }

  /*  @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTaskPlan(@PathVariable("taskPlanId") Long id ,@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlan) {
        taskPlan.setTaskPlanId(id);
        taskPlan.setGroupId(groupId);
        this.taskPlanFacade.updateTaskplan(taskPlan);
    }
*/
}

