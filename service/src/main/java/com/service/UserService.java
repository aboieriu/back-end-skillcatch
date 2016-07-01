package com.service;

import facade.api.IGroupFacade;
import facade.api.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class UserService extends BaseService {

    @Autowired
    IUserFacade userFacade;

    @Autowired
    IGroupFacade groupFacade;

    @RequestMapping(value = "/api/projectGroup/{groupId}/user" , method = RequestMethod.GET)
    @ResponseBody
    public Set<User> getAllUser(@PathVariable("groupId") Long groupId) {
        return this.groupFacade.getUsers(groupId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user" , method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addUser(@PathVariable("groupId") Long groupId,@RequestBody User user) {
        this.groupFacade.addUserToGroup(groupId, user.getId());
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUserById(@PathVariable("userId") Long userId) {
        this.userFacade.deleteUserById(userId);
    }

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

}




















