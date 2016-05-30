package dao;

import model.ProjectGroup;
import model.Taskplan;
import model.User;

import java.util.Set;


public interface IGroupDao extends IGenericDao<ProjectGroup> {

    public Set<User> getUsers(Long groupId);
    public Set<Taskplan> getTaskplans(Long groupId);
    void updateGroup(ProjectGroup group);

    }
