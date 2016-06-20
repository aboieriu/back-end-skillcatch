package com.service;

import com.converter.AssignedProjectConverter;
import com.view.AssignedProjectView;
import facade.ITaskFacade;
import facade.ITaskplanFacade;
import facade.IUserFacade;
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

@Controller
@RequestMapping("/api/user")
public class AllUsersService extends BaseService {

    @Autowired
    ITaskFacade taskFacade;

    @Autowired
    ITaskplanFacade taskPlanFacade;

    @Autowired
    private IUserFacade allUsersFacade;

    private AssignedProjectConverter assignedProjectConverter = new AssignedProjectConverter();

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


    @RequestMapping(value = "/{userId}/assignedProjects",method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Set<AssignedProjectView> getAssignedProjects(@PathVariable("userId") Long userId){
        return this.assignedProjectConverter.convert(this.allUsersFacade.getAssignedProjects(userId));
    }
}
