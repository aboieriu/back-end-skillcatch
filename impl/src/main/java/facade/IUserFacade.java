package facade;

import model.ProjectGroup;
import model.Task;
import model.User;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;


public interface IUserFacade {
    User getUserFromGroup(Long groupId, Long userId);

    void addUser(User user);

    List<User> getAll();

    User getUserById(Long userId);

    void deleteUserById(Long userId);

    void updateUser(User user);

    User findByUserName(String username);

    Set<ProjectGroup> getAssignedProjects(Long userId);

    List<Task> getUserTasks(Long userId);
}
