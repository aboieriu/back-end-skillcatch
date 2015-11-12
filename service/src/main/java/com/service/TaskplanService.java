package com.service;

import facade.IUserFacade;
import model.Taskplan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CataVlad on 12-Nov-15.
 */

@Controller
public class TaskplanService {

    @Autowired
    ITaskPlanFacade taskPlanFacade;

    public ITaskPlanFacade getTaskPlanFacade() {
        return taskPlanFacade;
    }

    public void setTaskPlanFacade(ITaskPlanFacade taskPlanFacade) {
        this.taskPlanFacade = taskPlanFacade;
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.GET)
    @ResponseBody
    public List<Taskplan> getAllTaskPlans(@PathVariable("groupId") Long groupId)
    {
        return this.taskPlanFacade.getAll();
    }

    @RequestMapping(value = "skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.GET)
    @ResponseBody
    public Taskplan getTaskPlan(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId)
    {
        return this.taskPlanFacade.getTaskPlan(groupId, taskPlanId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTaskPlan(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId)
    {
        this.taskPlanFacade.deleteTaskPlan(groupId, taskPlanId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/" , method = RequestMethod.POST)
    @ResponseBody
    public void addTaskPlan(@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlanId)
    {
        //  userId.setGroupId(groupId);
        this.taskPlanFacade.add(taskPlanId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTaskPlan(@PathVariable("taskPlanId") Long id ,@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlan) {
        taskPlan.setTaskPlanId(id);
        //  user.setGroupId(groupId);
        this.taskPlanFacade.updateTaskPlan(taskPlan);
    }
}
