package com.service;

import facade.ITaskplanFacade;
import model.Taskplan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class TaskplanService {

    @Autowired
    ITaskplanFacade taskPlanFacade;

    public ITaskplanFacade getTaskPlanFacade() {
        return taskPlanFacade;
    }

    public void setTaskPlanFacade(ITaskplanFacade taskPlanFacade) {
        this.taskPlanFacade = taskPlanFacade;
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan" , method = RequestMethod.GET)
    @ResponseBody
    public List<Taskplan> getAllTaskPlans(@PathVariable("groupId") Long groupId)
    {
        return this.taskPlanFacade.getAllTaskplan();
    }

    /*@RequestMapping(value = "skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}",method = RequestMethod.GET)
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
*/
    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/" , method = RequestMethod.POST)
    @ResponseBody
    public void addTaskPlan(@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlanId)
    {
        //  userId.setGroupId(groupId);
        this.taskPlanFacade.addTaskplan(taskPlanId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTaskPlan(@PathVariable("taskPlanId") Long id ,@PathVariable("groupId") Long groupId,@RequestBody Taskplan taskPlan) {
        taskPlan.setTaskPlanId(id);
        //  user.setGroupId(groupId);
        this.taskPlanFacade.updateTaskplan(taskPlan);
    }
}
