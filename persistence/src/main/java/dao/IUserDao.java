package dao;

import model.Badge;
import model.ProjectGroup;
import model.Task;
import model.User;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Set;


public interface IUserDao extends IGenericDao<User> {

    public void updateUser(User myUser);
    public User getUser(Long groupId,Long userId);
    public void deleteUser(Long groupId , Long userId);
    public User findByUserName(String username);

    Set<ProjectGroup> getAssignedProjects(Long userId);

    List<Task> getUserTasks(Long userId);


}
