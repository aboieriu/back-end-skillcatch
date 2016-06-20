package facade;

import dao.IUserDao;
import model.Badge;
import model.ProjectGroup;
import model.Task;
import model.User;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UserFacade implements IUserFacade {

    @Autowired
    private IUserDao userDao;


    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public User getUserFromGroup(Long groupId, Long userId) {
        return this.userDao.getUser(groupId, userId);
    }

    @Override
    public User getUserById(Long userId) {
        return this.userDao.getById(userId);
    }

    @Override
    public void deleteUserById(Long userId) {
        this.userDao.deleteById(userId);
    }

    @Override
    public void addUser(User group) {
        this.userDao.add(group);
    }

    @Override
    public void updateUser(User group) {
        this.userDao.updateUser(group);
    }

    @Override
    public User findByUserName(String username) {

        return this.userDao.findByUserName(username);
    }

    @Override
    public Set<ProjectGroup> getAssignedProjects(Long userId) {
        return this.userDao.getAssignedProjects(userId);
    }

    @Override
    public Set<Task> getUserTasks(Long userId) {
        return this.userDao.getUserTasks(userId);
    }

    @Override
    public Set<Badge> getUserBadges(Long userId) {
        return this.userDao.getUserBadges(userId);
    }
}

