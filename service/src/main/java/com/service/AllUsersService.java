package com.service;


import facade.IUserFacade;
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
    private IUserFacade allUsersFacade;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers()
    {
        return this.allUsersFacade.getAll();
    }
    public IUserFacade getAllUsersFacade() {
        return allUsersFacade;
    }

    public void setAllUsersFacade(IUserFacade allUsersFacade) {
        this.allUsersFacade = allUsersFacade;
    }
}
