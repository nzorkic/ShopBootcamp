package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.repository.UserRepository;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final int SALT_LENGTH = 30;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User createUser(User user) {
        String salt = PasswordUtils.getSalt(SALT_LENGTH);
        String encryptedPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
        user.setPassword(encryptedPassword);
        user.setSalt(salt);
        return userRepository.save(user);
    }
}
