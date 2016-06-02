package com.service;

import facade.IGroupFacade;
import facade.IUserFacade;
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
    public Set<User> getAllUser(@PathVariable("groupId") Long groupId)
    {
        return this.groupFacade.getUsers(groupId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("groupId") Long groupId , @PathVariable("userId") Long userId)
    {
        return this.userFacade.getUserFromGroup(groupId, userId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user" , method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_DEV')")
    public void addUser(@PathVariable("groupId") Long groupId,@RequestBody User user)
    {

        this.groupFacade.addUserToGroup(groupId, user.getId());
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@PathVariable("userId") Long userId)
    {
        this.userFacade.deleteUserById(userId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("userId") Long id ,@PathVariable("groupId") Long groupId,@RequestBody User user) {
        user.setId(id);
        this.userFacade.updateUser(user);
    }

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

}




















