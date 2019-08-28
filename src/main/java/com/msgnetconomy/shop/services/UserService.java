package com.msgnetconomy.shop.services;

import com.msgnetconomy.shop.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserID(User user, Long uid);

    User saveUser(User user);

    User getUserByUserID(Long uid);

    ResponseEntity<User> updateUser(User user, Long uid);
}
