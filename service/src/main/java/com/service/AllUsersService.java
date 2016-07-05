package com.service;

import converter.AssignedProjectConverter;
import view.AssignedProjectView;
import facade.api.ITaskFacade;
import facade.api.ITaskplanFacade;
import facade.api.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@RequestMapping("deprecated/api/user")
public class AllUsersService extends BaseService {

    @Autowired
    ITaskFacade taskFacade;

    @Autowired
    ITaskplanFacade taskPlanFacade;

    @Autowired
    private IUserFacade allUsersFacade;

    private AssignedProjectConverter assignedProjectConverter = new AssignedProjectConverter();

    @RequestMapping(value = "/{userId}" , method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userId") Long id)
    {
        return this.allUsersFacade.getUserById(id);
    }

    @RequestMapping(value = "/{userId}" , method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateUser(@PathVariable("userId") Long id,@RequestBody User user)
    {
        user.setId(id);
        this.allUsersFacade.updateUser(user);
    }
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addUser(@RequestBody User user)
    {
        this.allUsersFacade.addUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("userId") Long id)
    {
        this.allUsersFacade.deleteUserById(id);
    }
}
