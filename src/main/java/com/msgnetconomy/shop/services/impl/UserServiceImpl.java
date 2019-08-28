package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.repository.UserRepository;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class UserServiceImpl implements UserService {

    private static final int SALT_LENGTH = 30;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUserID(User user, Long uid) {
        Optional<User> userdb = Optional.of(userRepository.getOne(uid));
        AtomicBoolean passwordsMatch = new AtomicBoolean();
        userdb.ifPresent(userData ->
                passwordsMatch.set(PasswordUtils.verifyUserPassword(
                        user.getPassword(), userData.getPassword(), userData.getSalt())));
        return passwordsMatch.get() ? userdb : null;
    }

    @Override
    public User saveUser(User user) {
        String salt = PasswordUtils.getSalt(SALT_LENGTH);
        String encryptedPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
        user.setPassword(encryptedPassword);
        user.setSalt(salt);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserID(Long uid) {
        return userRepository.getOne(uid);
    }

    @Override
    public ResponseEntity<User> updateUser(User user, Long id) {
        Optional<User> userdb = userRepository.findById(id);
        if (!userdb.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setUid(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
        //2.way
        //return userRepository.updateUser(
        //user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getUserId());
    }
}
