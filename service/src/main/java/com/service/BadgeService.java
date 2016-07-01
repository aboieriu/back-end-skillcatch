package com.service;

import facade.api.IBadgeFacade;
import facade.api.ITaskFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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
    public List<Badge> getBadgeFromTask(@PathVariable("groupId") Long groupId,@PathVariable("taskPlanId") Long taskPlanId,@PathVariable("taskId") Long taskId)
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBadge(@PathVariable("badgeId") Long badgeId)
    {
        this.badgeFacade.deleteBadge(badgeId);
    }
    

    public IBadgeFacade getBadgeFacade() {
        return badgeFacade;
    }

    public void setBadgeFacade(IBadgeFacade badgeFacade) {
        this.badgeFacade = badgeFacade;
    }
}

