package com.endpoint;

import facade.api.IBadgeFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import view.BadgeView;

import java.util.Set;

@Controller
@RequestMapping("/api/badges")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class BadgeResource {

    @Autowired
    private IBadgeFacade badgeFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<BadgeView> getBadges()throws Exception{
        return this.badgeFacade.getAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BadgeView getBadge(@PathVariable("id")Long badgeId)throws Exception{
        return this.badgeFacade.getOne(badgeId);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addBadge(@RequestBody Badge badge)throws Exception{
        this.badgeFacade.createBadge(badge);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBadge(@PathVariable("id") Long badgeId)throws Exception{
        this.badgeFacade.deleteBadge(badgeId);
    }

}
