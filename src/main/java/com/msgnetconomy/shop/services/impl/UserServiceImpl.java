package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.dao.UserDao;
import com.msgnetconomy.shop.domain.UserEntity;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public Optional<UserEntity> findByUsername(UserEntity user) {
        Optional<UserEntity> userdb = userDao.findByUsername(user.getUsername());
        if (userdb.isPresent()) {
            boolean passwordMatch = PasswordUtils.verifyUserPassword(user.getPassword(), userdb.get().getPassword(), userdb.get().getSaltPassword());
            if (passwordMatch) {
                return userdb;
            }
        }
        return null;//???
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        if (Objects.nonNull(user)) {
            String salt = PasswordUtils.getSalt(30);
            String mySecurePassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
            user.setPassword(mySecurePassword);
            user.setSaltPassword(salt);
            return userDao.save(user);
        }
        return null;//!!
    }

    @Override
    public UserEntity getUser(String username) {
        UserEntity userdb = userDao.getOne(username);
        if (Objects.nonNull(userdb)) {
            return userdb;
        }
        return null;//??
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userDao.updateUser(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getUserId());
    }
}
