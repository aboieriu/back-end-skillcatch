package com.service;


import com.converter.AssignedProjectConverter;
import com.converter.UserTasksConverter;
import com.view.AssignedProjectView;
import com.view.UserTasks;
import facade.ITaskFacade;
import facade.IUserFacade;
import model.ProjectGroup;
import model.Task;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/user")
public class AllUsersService extends BaseService {


    @Autowired
    private IUserFacade allUsersFacade;

    @Autowired
    private ITaskFacade iTaskFacade;

    private AssignedProjectConverter assignedProjectConverter = new AssignedProjectConverter();

    private UserTasksConverter userTasksConverter=new UserTasksConverter();

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
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
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


    @RequestMapping(value = "/{userId}/assignedProjects",method = RequestMethod.GET)
    @ResponseBody
    public Set<AssignedProjectView> getAssignedProjects(@PathVariable("userId") Long userId){
        return this.assignedProjectConverter.convert(this.allUsersFacade.getAssignedProjects(userId));
    }
    @RequestMapping(value = "/{userId}/tasks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<UserTasks> getUserTasks(@PathVariable("userId") Long userId){
        return  this.userTasksConverter.convert(this.allUsersFacade.getUserTasks(userId));

    }

}
