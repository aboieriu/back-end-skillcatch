package com.endpoint;


import converter.TaskPlanConverter;
import model.TaskPlan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import view.TaskPlanView;
import view.UserView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
@Controller
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserResource {

    @Autowired
    private IUserFacade userFacade;
    @Autowired
    private TaskPlanConverter taskPlanConverter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<UserView> getUsers() throws Exception {
        return this.userFacade.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public UserView getOneUser(@PathVariable("id") Long userId) throws Exception {
        return this.userFacade.getOne(userId);
    }
    @RequestMapping(value = "/{userId}/getUserTaskPlans",method = RequestMethod.GET)
    @ResponseBody
    public Set<TaskPlanView> getUserTaskPlans(@PathVariable("userId")Long userId)throws Exception{
        Set<TaskPlan> taskPlans=this.userFacade.getUserTaskPlans(userId);
        return taskPlans.stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@RequestBody User user) throws Exception {
        String password=user.getPassword();
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        User encodedPasswordUser=new User(user.getName(),user.getSurname(),user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getAddress(),user.getImage(),user.getUserRole(),user.getTaskPlans(),user.getProjects(),user.getAddedOn());
        this.userFacade.addUser(encodedPasswordUser);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("id") Long userId,@RequestBody User user) throws Exception {
        user.setId(userId);
        this.userFacade.updateUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long userId) throws Exception {
        this.userFacade.deleteUserById(userId);
    }
    @RequestMapping(value = "/{userId}/assignToProject/{projectId}", method = RequestMethod.PUT)
    @ResponseBody
    public void assignUserToProject(@PathVariable("userId")Long userId ,@PathVariable("projectId")Long projectId)throws Exception{
        this.userFacade.assignUserToProject(userId,projectId);
    }

    @RequestMapping(value = "/projectUnAssignedUsers/{projectId}",method = RequestMethod.GET)
    @ResponseBody
    public Set<UserView> getProjectUnAssignedUsers(@PathVariable("projectId")Long projectId){
        return this.userFacade.getProjectUnAssignedUsers(projectId);
    }
    @RequestMapping(value="/{userId}/removeTaskPlanFromUser/{taskPlanId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTaskPlanFromUser(@PathVariable("userId")Long userId, @PathVariable("taskPlanId")Long taskPlanId){
        this.userFacade.removeTaskPlanFromUser(userId,taskPlanId);
    }
    @RequestMapping(value = "/{userId}/assignTaskPlanToUser/{taskPlanId}", method = RequestMethod.PUT)
    @ResponseBody
    public void assignTaskPlanToUser(@PathVariable("userId")Long userId,@PathVariable("taskPlanId") Long taskPlanId){
        this.userFacade.assignTaskPlanToUser(userId,taskPlanId);
    }


    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
