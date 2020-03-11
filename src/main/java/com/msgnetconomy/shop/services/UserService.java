package com.msgnetconomy.shop.services;

import com.msgnetconomy.shop.domain.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User findUserByUsername(String username);

    User createUser(User user);

    void updateUser(User user, String name);
}
