package facade.impl;

import converter.UserConverter;
import dao.api.IUserDao;
import facade.api.IUserFacade;
import model.Badge;
import model.Project;
import model.Task;
import model.User;


import org.springframework.beans.factory.annotation.Autowired;
import view.UserView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserFacade implements IUserFacade {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private UserConverter userConverter;


    @Override
    public Set<UserView> getAll() {
        return this.userDao.getAll().stream().map(user -> userConverter.convert(user)).collect(Collectors.toSet());
    }

    @Override
    public UserView getOne(Long userId) {
        User user = userDao.getById(userId);
        return userConverter.convert(user);
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
    public Set<Badge> getUserBadges(Long userId) {
        return this.userDao.getUserBadges(userId);
    }

}

