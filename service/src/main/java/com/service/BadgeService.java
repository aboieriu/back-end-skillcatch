package com.service;

import facade.IBadgeFacade;
import facade.ITaskFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Controller

public class BadgeService extends BaseService {

    @Autowired
    private IBadgeFacade badgeFacade;

    @Autowired
    private ITaskFacade taskFacade;

    @RequestMapping(value = "/api/badge" , method = RequestMethod.GET)
    @ResponseBody
    public List<Badge> getAllBadge()
    {
        return this.badgeFacade.getAllBadge();
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge" , method = RequestMethod.GET)
    @ResponseBody
    public Set<Badge> getBadgeFromTask(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId)
    {
        return this.taskFacade.getBadgeFromTask(taskId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge/{badgeId}" , method = RequestMethod.GET)
    @ResponseBody
    public Badge getBadge(@PathVariable("groupId") Long id,@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId,@PathVariable("badgeId") Long badgeId)
    {
        return this.badgeFacade.getBadgeById(id,taskPlanId,taskId,badgeId);
    }


    @RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge/{badgeId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBadge(@PathVariable("badgeId") Long badgeId)
    {
        this.badgeFacade.deleteBadge(badgeId);
    }
    /*

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}/badge" , method = RequestMethod.GET)
    @ResponseBody
    public Badge getBadgeFromUser(@PathVariable("groupId") Long groupId,@PathVariable("userId") Long userId)
    {
        return this.badgeFacade.getBadgeFromUser(groupId, userId);
    }
*/

@RequestMapping(value = "/api/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge",method = RequestMethod.POST)
@ResponseBody
public void addBadge(@PathVariable("taskId") Long taskId,@RequestBody Badge badge)
{

    badge.setTask(taskFacade.getTaskById(taskId));
    this.badgeFacade.addBadgeToTask(taskId,badge);
}
    public IBadgeFacade getBadgeFacade() {
        return badgeFacade;
    }

    public void setBadgeFacade(IBadgeFacade badgeFacade) {
        this.badgeFacade = badgeFacade;
    }

}

