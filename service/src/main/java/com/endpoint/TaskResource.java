package com.endpoint;

import facade.api.ITaskFacade;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import view.TaskWithBadgesView;

import java.util.Set;

@Controller
@RequestMapping("/api/tasks")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class TaskResource {
    @Autowired
    private ITaskFacade taskFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<TaskWithBadgesView> getTasks() throws Exception {
        return this.taskFacade.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TaskWithBadgesView getTask(@PathVariable("id") Long taskId) throws Exception {
        return taskFacade.getOneTask(taskId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateTask(@RequestBody Task task) throws Exception {
        this.taskFacade.updateOneTask(task);
    }
   @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTask(@PathVariable("id") Long taskId)throws Exception{
        this.taskFacade.deleteOne(taskId);
    }
    @RequestMapping(value = "/{taskId}/assignBadge/{badgeId}",method = RequestMethod.PUT)
    @ResponseBody
    public void assignBadgeToTask(@PathVariable("taskId")Long taskId,@PathVariable("badgeId") Long badgeId){
        this.taskFacade.assignBadgeToTask(taskId,badgeId);
    }
    @RequestMapping(value = "/{taskId}/removeBadgeFromTask/{badgeId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void removeBadgeFromTask(@PathVariable("taskId") Long taskId,@PathVariable("badgeId") Long badgeId) throws Exception {
        this.taskFacade.removeBadgeFromTask(taskId,badgeId);
    }

}
