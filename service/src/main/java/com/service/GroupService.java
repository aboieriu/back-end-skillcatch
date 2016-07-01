package com.service;

import converter.ProjectConverter;
import facade.api.IGroupFacade;
import facade.api.IProjectFacade;
import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import view.ProjectView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/projectGroup")
public class GroupService extends BaseService {

    @Autowired
    private IGroupFacade groupFacade;

    private ProjectConverter projectConverter=new ProjectConverter();

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Set<ProjectView> getAllGroup() {return this.projectConverter.convert(this.groupFacade.getAllProjects());}


    @RequestMapping(value = "/{groupId}" , method = RequestMethod.GET)
    @ResponseBody
    public Project getGroup(@PathVariable("groupId") Long id)
    {
        return this.groupFacade.getGroupById(id);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addGroup(@RequestBody Project group)
    {
        this.groupFacade.addGroup(group);
    }

    @RequestMapping(value = "/{groupId}" , method = RequestMethod.PUT)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateGroup(@PathVariable("groupId") Long id,@RequestBody Project group)
    {
        group.setId(id);
        this.groupFacade.updateGroup(group);
    }

    @RequestMapping(value = "/{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteGroup(@PathVariable("groupId") Long id)
    {
        this.groupFacade.deleteGroup(id);
    }




}
