package com.service;


import facade.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CataVlad on 26-Oct-15.
 */
@Controller
@RequestMapping("/api/user")
public class AllUsersService {


    @Autowired
    private IUserFacade allUsersFacade;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers()
    {
        return this.allUsersFacade.getAll();
    }

    @RequestMapping(value = "/{userId}" , method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userId") Long id)
    {
        return this.allUsersFacade.getUserById(id);
    }

    @RequestMapping(value = "/{userId}" , method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("userId") Long id,@RequestBody User user)
    {
        user.setId(id);
        this.allUsersFacade.updateUser(user);
    }
    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody User user)
    {
        this.allUsersFacade.addUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("userId") Long id)
    {
        this.allUsersFacade.deleteUserById(id);
    }




}
