package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.repository.UserRepository;
import com.msgnetconomy.shop.domain.UserEntity;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserServiceImpl implements UserService {

    private static final int SALT_LENGTH = 30;

    @Resource
    UserRepository userRepository;

    @Override
    public Optional<UserEntity> findByUsername(UserEntity user) {
        Optional<UserEntity> userdb = userRepository.findByUsername(user.getUsername());
        AtomicBoolean passwordsMatch = new AtomicBoolean();
        userdb.ifPresent(userData ->
                passwordsMatch.set(PasswordUtils.verifyUserPassword(
                        user.getPassword(), userData.getPassword(), userData.getSalt())));
        return passwordsMatch.get() ? userdb : null;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        String salt = PasswordUtils.getSalt(SALT_LENGTH);
        String encryptedPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
        user.setPassword(encryptedPassword);
        user.setSalt(salt);
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        UserEntity user = userRepository.getOne(username);
        return user;
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepository.updateUser(
                user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getUserId());
    }
}
