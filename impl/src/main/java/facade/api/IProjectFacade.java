package facade.api;

import view.AssignedProjectView;

import java.util.Set;

/**
 * Created by aboieriu on 6/29/16.
 */
public interface IProjectFacade {
    /**
     * Returns assigned projects for a user
     * @param userId
     * @return
     */
    Set<AssignedProjectView> getAssignedProjects(Long userId);
    AssignedProjectView getAssignedProject(Long userId, Long projectId);
}
