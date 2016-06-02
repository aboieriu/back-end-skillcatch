package facade;

import dao.IUserDao;
import model.ProjectGroup;
import model.Task;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UserFacade implements IUserFacade {

    @Autowired
    private IUserDao userDao;


    public List<User> getAll() {
        return this.userDao.getAll();
    }

    public User getUserFromGroup(Long groupId, Long userId) {
        return this.userDao.getUser(groupId, userId);
    }

    public User getUserById(Long userId) {
        return this.userDao.getById(userId);
    }

    public void deleteUserById(Long userId) {
        this.userDao.deleteById(userId);
    }

    public void addUser(User group) {
        this.userDao.add(group);
    }

    public void updateUser(User group) {
        this.userDao.updateUser(group);
    }

    public User findByUserName(String username) {

        return this.userDao.findByUserName(username);
    }


    public Set<ProjectGroup> getAssignedProjects(Long userId) {
        return this.userDao.getAssignedProjects(userId);
    }

    public Set<Task> getUserTasks(Long userId) {
        return this.userDao.getUserTasks(userId);
    }
}

