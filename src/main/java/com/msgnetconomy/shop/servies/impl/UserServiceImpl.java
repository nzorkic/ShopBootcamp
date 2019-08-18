package com.msgnetconomy.shop.servies.impl;

import com.msgnetconomy.shop.dao.UserDao;
import com.msgnetconomy.shop.domain.UserEntity;
import com.msgnetconomy.shop.servies.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public UserEntity login(String username, String password) {
        UserEntity user = userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public UserEntity register(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
