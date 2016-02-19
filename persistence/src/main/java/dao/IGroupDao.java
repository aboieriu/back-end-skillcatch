package dao;

import model.ProjectGroup;
import model.Taskplan;
import model.User;

import java.util.Set;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IGroupDao extends IGenericDao<ProjectGroup> {

     Set<User> getUsers(Long groupId);
     Set<Taskplan> getTaskplans(Long groupId);

    }
