package com.msgnetconomy.shop.repository;

import com.msgnetconomy.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByUsername(String username);
//2.way
//    @Modifying
//    @Transactional
//    @Query("UPDATE UserEntity u SET u.username=?1, u.password=?2, u.firstName=?3, u.lastName=?4 WHERE u.userId=?5")
//    UserEntity updateUser(String username, String password, String firstName, String lastName, Integer userID);
}
