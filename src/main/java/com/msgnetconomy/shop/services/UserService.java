package com.msgnetconomy.shop.services;

import com.msgnetconomy.shop.domain.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User findUserByUsername(String username);

    User saveUser(User user);

    ResponseEntity<User> updateUser(User user, Long uid);
}
