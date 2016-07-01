package facade.impl;

import converter.AssignedProjectConverter;
import converter.ProjectConverter;
import dao.api.IProjectDao;
import dao.api.IUserDao;
import facade.api.IProjectFacade;
import facade.api.IUserFacade;
import model.Project;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.AssignedProjectView;
import view.ProjectView;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
public class ProjectFacade  implements IProjectFacade{

    @Autowired
    private IProjectDao projectDao;

    @Autowired
    private IUserFacade userFacade;





    @Autowired
    private AssignedProjectConverter assignedProjectConverter;

    @Override
    public Set<AssignedProjectView> getAssignedProjects(Long userId) {
        User loggedUser = userFacade.getUserById(userId);
        return loggedUser.getProjects().stream().map(project -> assignedProjectConverter.convert(project)).collect(Collectors.toSet());
    }

}

