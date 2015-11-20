package dao;

import model.Group;

import java.util.List;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IGroupDao extends IGenericDao<Group> {

    void updateGroup(Group group);

}
