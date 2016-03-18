package com.service;

import facade.IGroupFacade;
import facade.ITaskplanFacade;
import model.Taskplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class TaskplanService extends BaseService{

    @Autowired
    ITaskplanFacade taskPlanFacade;
    @Autowired
    IGroupFacade groupFacade;



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

    @Transactional
    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.POST)
    @ResponseBody
    public void addTaskPlan(@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlanId)
    {
        this.groupFacade.addTaskPlanToGroup(groupId,taskPlanId);
    }

   @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTaskPlan(@PathVariable("taskPlanId") Long taskPlanId)
    {
        this.taskPlanFacade.deleteTaskplan(taskPlanId);
    }
    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTaskPlan(@PathVariable("taskPlanId") Long id ,@RequestBody Taskplan taskPlan) {
        taskPlan.setId(id);

        this.taskPlanFacade.updateTaskplan(taskPlan);
    }

}

