/**package com.service;

import model.Task;
import model.Taskplan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskService {


    @Autowired
    ITaskFacade taskFacade;

    public ITaskFacade getTaskFacade() {
        return taskFacade;
    }

    public void setTaskFacade(ITaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task" , method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getAllTasks(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId)
    {
        return this.taskFacade.getAll();
    }

    @RequestMapping(value = "skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}",method = RequestMethod.GET)
    @ResponseBody
    public Taskplan getTask(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId)
    {
        return this.taskFacade.getTask(groupId, taskPlanId, taskId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId)
    {
        this.taskFacade.deleteTask(groupId, taskPlanId, taskId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task" , method = RequestMethod.POST)
    @ResponseBody
    public void addTask(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId ,@RequestBody Task taskId)
    {
        //  userId.setGroupId(groupId);
        this.taskFacade.add(taskId);
    }

    @RequestMapping(value = "/skillcatch/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTask(@PathVariable("taskId") Long id ,@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("groupId") Long groupId,@RequestBody Task task) {
        task.setTaskId(id);
        //  user.setGroupId(groupId);
        this.taskFacade.updateTask(task);
    }
}*/


