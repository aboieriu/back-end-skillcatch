package com.service;

import facade.IBadgeFacade;
import facade.ITaskFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/api")
public class BadgeService {

    @Autowired
    private IBadgeFacade badgeFacade;

    @Autowired
    private ITaskFacade taskFacade;

    @RequestMapping(value = "/badge" , method = RequestMethod.GET)
    @ResponseBody
    public List<Badge> getAllBadges()
    {
        return this.badgeFacade.getAllBadge();
    }

    @RequestMapping(value = "/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge/{badgeId}" , method = RequestMethod.GET)
    @ResponseBody
    public Badge getBadge(@PathVariable("groupId") Long id,@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId,@PathVariable("badgeId") Long badgeId)
    {
        return this.badgeFacade.getBadgeById(id, taskPlanId, taskId, badgeId);
    }

    @RequestMapping(value = "/projectGroup/{groupId}/taskPlan/{taskPlanId}/task/{taskId}/badge/{badgeId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBadge(@PathVariable("groupId") Long groupId , @PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId,@PathVariable("badgeId") Long badgeId)
    {
        this.badgeFacade.deleteBadge(groupId,taskPlanId,taskId,badgeId);
    }

    @RequestMapping(value = "/projectGroup/{groupId}/user/{userId}/badge" , method = RequestMethod.GET)
    @ResponseBody
    public Badge getBadgeFromUser(@PathVariable("groupId") Long groupId,@PathVariable("userId") Long userId)
    {
        return this.badgeFacade.getBadgeFromUser(groupId, userId);
    }

    public IBadgeFacade getBadgeFacade() {
        return badgeFacade;
    }

    public void setBadgeFacade(IBadgeFacade badgeFacade) {
        this.badgeFacade = badgeFacade;
    }

}


