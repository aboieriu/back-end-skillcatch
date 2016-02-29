package dao;

import model.ProjectGroup;
import model.Taskplan;
import model.User;

import java.util.Set;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IGroupDao extends IGenericDao<ProjectGroup> {

    public Set<User> getUsers(Long groupId);
    public Set<Taskplan> getTaskplans(Long groupId);
    void updateGroup(ProjectGroup group);

    }
