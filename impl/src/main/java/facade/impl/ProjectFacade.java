package facade.impl;

import converter.AssignedProjectConverter;
import dao.api.IProjectDao;
import dao.api.IUserDao;
import facade.api.IProjectFacade;
import facade.api.IUserFacade;
import model.Project;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.AssignedProjectView;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
public class ProjectFacade  implements IProjectFacade{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private AssignedProjectConverter assignedProjectConverter;

    @Override
    public Set<AssignedProjectView> getAssignedProjects(Long userId) {
        User loggedUser = userFacade.getUserById(userId);
        return loggedUser.getProjects().stream().map(project -> assignedProjectConverter.convert(project)).collect(Collectors.toSet());
    }

    @Override
    public AssignedProjectView getAssignedProject(Long userId, Long projectId) {
        if (userId == null || projectId == null){
            return null;
        }
        User loggedUser = userFacade.getUserById(userId);
        Set<AssignedProjectView> assignedProjectViews = loggedUser.getProjects().stream()
                .filter(project -> projectId.equals(project.getId()))
                .map(project -> assignedProjectConverter.convert(project)).collect(Collectors.toSet());
        return assignedProjectViews.isEmpty() ? null : assignedProjectViews.iterator().next();
    }
}

