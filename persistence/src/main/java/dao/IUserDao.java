package dao;

import model.User;

import java.util.List;

/**
 * Created by Mirela_2 on 10/21/2015.
 */
public interface IUserDao extends IGenericDao<User> {

    public void updateUser(User myUser);

    public User getUser(Long groupId,Long userId);


}
