package dao.api;

import model.Project;
import model.TaskPlan;
import model.User;

import java.util.Set;


public interface IProjectDao extends IGenericDao<Project> {

    public Set<User> getUsers(Long groupId);
    public Set<TaskPlan> getTaskplans(Long groupId);
    void updateProject(Project group);
}
