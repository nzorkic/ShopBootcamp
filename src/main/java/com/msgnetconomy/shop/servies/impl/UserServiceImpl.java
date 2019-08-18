package com.msgnetconomy.shop.servies.impl;

import com.msgnetconomy.shop.dao.UserDao;
import com.msgnetconomy.shop.servies.UserService;
import org.apache.catalina.User;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User register(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
         return userDao.findByUsername(username);
    }
}
