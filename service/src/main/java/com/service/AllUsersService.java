package com.service;

import facade.IAllUsersFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by CataVlad on 26-Oct-15.
 */
@Controller
@RequestMapping("/users")
public class AllUsersService {


    @Autowired
    private IAllUsersFacade allUsersFacade;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers()
    {
        return this.allUsersFacade.getAllUsers();
    }
    public IAllUsersFacade getAllUsersFacade() {
        return allUsersFacade;
    }

    public void setAllUsersFacade(IAllUsersFacade allUsersFacade) {
        this.allUsersFacade = allUsersFacade;
    }
}
