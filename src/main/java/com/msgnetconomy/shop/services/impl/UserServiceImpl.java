package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.repository.UserRepository;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public User saveUser(User user) {
        String salt = PasswordUtils.getSalt(SALT_LENGTH);
        String encryptedPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
        user.setPassword(encryptedPassword);
        user.setSalt(salt);
        return userRepository.save(user);
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
