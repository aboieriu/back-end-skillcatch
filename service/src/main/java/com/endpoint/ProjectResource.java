package com.endpoint;

import facade.api.IProjectFacade;
import facade.api.ITaskplanFacade;
import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import view.ProjectView;

import java.util.Set;

/**
 * Created by aboieriu on 6/29/16.
 */
@Controller
@RequestMapping("/api/projects")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ProjectResource {

    @Autowired
    private IProjectFacade projectFacade;
    @Autowired
    private ITaskplanFacade taskplanFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<ProjectView> getProjects() throws Exception {
        return this.projectFacade.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProjectView getProject(@PathVariable("id") Long projectId) throws Exception {
        return this.projectFacade.getOne(projectId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void createProject(@RequestBody Project project) throws Exception {
        this.projectFacade.createOne(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateProject(@RequestBody Project project) throws Exception {
        this.projectFacade.updateOne(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProject(@PathVariable("id") Long projectId) throws Exception {
        this.projectFacade.deleteOne(projectId);
    }

    @RequestMapping(value = "/{projectId}/removeUserFromProject/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeUserFromProject(@PathVariable("projectId") Long projectId,@PathVariable("userId")Long userId) throws Exception {
        this.projectFacade.removeUserFromProject(projectId,userId);
    }



    public IProjectFacade getProjectFacade() {
        return projectFacade;
    }

    public void setProjectFacade(IProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }
}
