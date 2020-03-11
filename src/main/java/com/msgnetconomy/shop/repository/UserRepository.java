package com.msgnetconomy.shop.repository;

import com.msgnetconomy.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = ?1 WHERE u.username = ?2")
    int updateUser(String name, String username);
}
