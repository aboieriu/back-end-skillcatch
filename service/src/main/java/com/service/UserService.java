package com.service;

        import facade.IGroupFacade;
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
public class UserService {

    @Autowired
    IUserFacade userFacade;
    @Autowired
    IGroupFacade groupFacade;

    @RequestMapping(value = "/api/group/{groupId}/user" , method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(@PathVariable("groupId") Long groupId)
    {
        return this.userFacade.getAllUsers(groupId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("groupId") Long groupId , @PathVariable("userId") Long userId)
    {
        return this.userFacade.getUser(groupId, userId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/{userId}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("groupId") Long groupId , @PathVariable("userId") Long userId)
    {
        this.userFacade.deleteUser(groupId, userId);
    }

    @RequestMapping(value = "/api/projectGroup/{groupId}/user/" , method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@PathVariable("groupId") Long groupId,@RequestBody User user)
    {

        this.groupFacade.addUserToGroup(groupId, user);
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




















