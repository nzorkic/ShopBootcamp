package com.msgnetconomy.shop.repository;

import com.msgnetconomy.shop.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity u SET u.username=?1, u.password=?2, u.firstName=?3, u.lastName=?4 WHERE u.userId=?5")
    UserEntity updateUser(String username, String password, String firstName, String lastName, Integer userID);
}
