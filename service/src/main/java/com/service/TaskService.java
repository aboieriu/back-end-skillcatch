package com.service;

import facade.ITaskFacade;
import facade.ITaskplanFacade;
import model.Task;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class TaskService extends BaseService {


    @Autowired
    ITaskFacade taskFacade;
    @Autowired
    ITaskplanFacade taskPlanFacade;



    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task" , method = RequestMethod.GET)
    @ResponseBody
    public Set<Task> getAllTasks(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId)
    {
        return this.taskPlanFacade.getTasks(taskPlanId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}",method = RequestMethod.GET)
    @ResponseBody
    public Task getTask(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId)
    {
        return this.taskFacade.getTask(groupId, taskPlanId, taskId);
    }
    @Transactional
    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task" , method = RequestMethod.POST)
    @ResponseBody
    public void addTask(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId ,@RequestBody Task task)
    {

        this.taskPlanFacade.addTaskToTaskPlan(taskPlanId,task);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("taskId") Long taskId)
    {
        this.taskFacade.deleteTask(taskId);
    }


    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}", method = RequestMethod.PUT)
    @ResponseBody

    public void updateTask(@PathVariable("taskId") Long id,@RequestBody Task task) {
        task.setId(id);

        this.taskFacade.updateTask(task);
    }

}


