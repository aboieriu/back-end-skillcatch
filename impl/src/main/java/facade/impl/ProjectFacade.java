package facade.impl;

import converter.AssignedProjectConverter;
import converter.ProjectConverter;
import dao.api.IProjectDao;
import dao.api.ITaskplanDao;
import dao.api.IUserDao;
import facade.api.IProjectFacade;
import facade.api.IUserFacade;
import model.Project;
import model.TaskPlan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import view.AssignedProjectView;
import view.ProjectView;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
@Transactional
public class ProjectFacade  implements IProjectFacade{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserFacade userFacade;

    @Autowired
    private IProjectDao projectDao;

    @Autowired
    private AssignedProjectConverter assignedProjectConverter;

    @Autowired
    private ProjectConverter projectConverter;

    @Autowired
    private ITaskplanDao taskplanDao;

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

    @Override
    public ProjectView getOne(Long projectId) {
        Project project = projectDao.getById(projectId);
        return projectConverter.convert(project);
    }

    @Override
    public Set<ProjectView> getAll() {
        List<Project> projects = projectDao.getAll();
        return projects.stream().map(project -> projectConverter.convert(project)).collect(Collectors.toSet());
    }

    @Override
    public void updateOne(Project project) {
        Project itemFromDbs = this.projectDao.getById(project.getId());
        if (itemFromDbs != null) {
            if(!Objects.equals(project.getName(), "") && project.getName() !=null){
                itemFromDbs.setName(project.getName());
            }
            if(!Objects.equals(project.getDescriptions(), "") && project.getDescriptions() !=null){
                itemFromDbs.setDescriptions(project.getDescriptions());
            }
            if (project.getTaskPlans() != null) {
                project.getTaskPlans().stream().forEach(taskPlan -> {
                    TaskPlan taskPlanToAdd = taskplanDao.getById(taskPlan.getId());
                    if (taskPlanToAdd == null) {
                        itemFromDbs.getTaskPlans().add(taskPlan);
                    }
                });
            }
            this.projectDao.updateProject(itemFromDbs);
        }
    }

    @Override
    public void removeUserFromProject(Long projectId, Long userId) {
        User userFromDbs=this.userDao.getById(userId);
        if(userFromDbs!=null){
            userFromDbs.getProjects().stream().forEach(project -> {
                if(project.getId().equals(projectId)){
                    userFromDbs.getTaskPlans().removeIf(taskPlan -> project.getTaskPlans().contains(taskPlan));
                }
            });
            userFromDbs.getProjects().removeIf(project -> project.getId().equals(projectId));
            userFromDbs.setProjects(userFromDbs.getProjects());
        }
        this.projectDao.removeUserFromProject(projectId,userFromDbs);
    }


    public void deleteOne(Long projectId){
        this.projectDao.deleteById(projectId);
    }

    public void createOne(Project project){
        this.projectDao.add(project);
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public IProjectDao getProjectDao() {
        return projectDao;
    }

    public void setProjectDao(IProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public AssignedProjectConverter getAssignedProjectConverter() {
        return assignedProjectConverter;
    }

    public void setAssignedProjectConverter(AssignedProjectConverter assignedProjectConverter) {
        this.assignedProjectConverter = assignedProjectConverter;
    }

    public ProjectConverter getProjectConverter() {
        return projectConverter;
    }

    public void setProjectConverter(ProjectConverter projectConverter) {
        this.projectConverter = projectConverter;
    }

    public ITaskplanDao getTaskplanDao() {
        return taskplanDao;
    }

    public void setTaskplanDao(ITaskplanDao taskplanDao) {
        this.taskplanDao = taskplanDao;
    }
}

