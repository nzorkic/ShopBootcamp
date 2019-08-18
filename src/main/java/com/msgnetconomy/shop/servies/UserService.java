package com.msgnetconomy.shop.servies;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User login(String username, String password);

    User register(User user);

    User findByUsername(String username);
}
