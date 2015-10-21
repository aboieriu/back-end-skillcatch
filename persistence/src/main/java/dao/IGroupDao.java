package dao;

import model.Group;

import java.util.List;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IGroupDao {
    List<Group> getAllGroup();
    Group getGroup(Long id);
    void addGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(Long id);
}
