package com.endpoint;


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
import view.UserView;

import java.util.*;

/**
 * Created by aboieriu on 6/29/16.
 */
@Controller
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserResource {

    @Autowired
    private IUserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<UserView> getAssignedProjects() throws Exception {
        return this.userFacade.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public UserView getAssignedProject(@PathVariable("id") Long userId) throws Exception {
        return this.userFacade.getOne(userId);
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
    public void updateUser(@RequestBody User user) throws Exception {
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




    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
