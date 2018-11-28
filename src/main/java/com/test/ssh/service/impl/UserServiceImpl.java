package com.test.ssh.service.impl;

import com.test.ssh.dao.UserDao;
import com.test.ssh.domain.User;
import com.test.ssh.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
}
