package com.service;

/**
 * Created by CataVlad on 26-Oct-15.
 */


import facade.IGroupFacade;
import model.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/projectGroup")
public class GroupService {

    @Autowired
    private IGroupFacade groupFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectGroup> getAllGroup() {return this.groupFacade.getAllGroup();}

    @RequestMapping(value = "/{groupId}" , method = RequestMethod.GET)
    @ResponseBody
    public ProjectGroup getGroup(@PathVariable("groupId") Long id)
    {
        return this.groupFacade.getGroupById(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseBody
    public void addGroup(@RequestBody ProjectGroup group)
    {
        this.groupFacade.addGroup(group);
    }

    @RequestMapping(value = "/{groupId}" , method = RequestMethod.PUT)
    @ResponseBody
    public void updateGroup(@PathVariable("groupId") Long id,@RequestBody ProjectGroup group)
    {
        group.setId(id);
        this.groupFacade.updateGroup(group);
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteGroup(@PathVariable("groupId") Long id)
    {
        this.groupFacade.deleteGroup(id);
    }

    public IGroupFacade getGroupFacade() {
        return groupFacade;
    }

    public void setGroupFacade(IGroupFacade groupFacade) {
        this.groupFacade = groupFacade;
    }


}
