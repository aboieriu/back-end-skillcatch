package dao;

import model.Group;
import model.Taskplan;
import model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IGroupDao extends IGenericDao<Group> {

    public Set<User> getUsers(Long groupId);
    public Set<Taskplan> getTaskplans(Long groupId);

    }
