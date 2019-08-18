package com.msgnetconomy.shop.servies;


import com.msgnetconomy.shop.domain.UserEntity;

public interface UserService {

    UserEntity login(String username, String password);

    UserEntity register(UserEntity user);

    UserEntity findByUsername(String username);
}
