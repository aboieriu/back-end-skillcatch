package com.converter;

import com.view.AssignedProjectView;
import model.ProjectGroup;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amusat on 6/7/2016.
 */
public class AssignedProjectConverter {

    public AssignedProjectView convert(ProjectGroup projectGroup) {
        if (projectGroup == null) {
            return null;
        }

        return new AssignedProjectView(projectGroup.getId(), projectGroup.getName(), projectGroup.getDescriptions(), projectGroup.getStatus());
    }

    public Set<AssignedProjectView> convert(Set<ProjectGroup> projectGroup) {
        Set<AssignedProjectView> response = new HashSet<>();
       if (projectGroup == null || projectGroup.isEmpty()) {
           return response;
       }

        for (ProjectGroup projectGroupItem : projectGroup) {
            response.add(this.convert(projectGroupItem));
        }

        return response;
    }
}
