package facade;

import model.User;

import java.util.List;

/**
 * Created by Adi on 10/26/2015.
 */
public interface IUserFacade {

    public List<User> getAll(Long id);


    public User getUser(Long groupId, Long userId);


    public void deleteUser(Long groupId, Long userId);


    public void add(User group);


    public void updateUser(User group);

    List<User> getAll();
}
