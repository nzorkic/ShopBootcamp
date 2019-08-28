package com.msgnetconomy.shop.services;

import com.msgnetconomy.shop.domain.UserEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findByUsername(UserEntity user);

    UserEntity saveUser(UserEntity user);

    UserEntity getUserByUsername(String username);

    UserEntity updateUser(UserEntity user);
}
