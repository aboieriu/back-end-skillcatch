package dao.api;

import model.Project;
import model.TaskPlan;
import model.User;

import java.util.Set;


public interface IProjectDao extends IGenericDao<Project> {


    void updateProject(Project group);
    void deleteById(Long projectId);
    void removeUserFromProject(Long projectId, User userFromDbs);
}
