package com.service;

import facade.IBadgeFacade;
import facade.IUserFacade;
import model.Badge;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
@RequestMapping("/skillcatch/api/badge")
public class BadgeService {

    @Autowired
    private IBadgeFacade badgeFacade;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ResponseBody
    public List<Badge> getAllBadges()
    {
        return this.badgeFacade.getAllBadge();
    }

    public IBadgeFacade getBadgeFacade() {
        return badgeFacade;
    }

    public void setBadgeFacade(IBadgeFacade badgeFacade) {
        this.badgeFacade = badgeFacade;
    }

}


