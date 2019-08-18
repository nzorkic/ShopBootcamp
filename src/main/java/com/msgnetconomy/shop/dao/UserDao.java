package com.msgnetconomy.shop.dao;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT user FROM user u WHERE u.username=?1")
    User findByUsername(String username);
}
