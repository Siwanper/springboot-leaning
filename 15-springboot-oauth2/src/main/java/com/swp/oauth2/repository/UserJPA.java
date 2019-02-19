package com.swp.oauth2.repository;

import com.swp.oauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-19 3:26 PM
 */
public interface UserJPA extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = lower(:username) ")
    User findByUsernameCaseInsensitive(@Param("username") String username);


    User findByUsername(String username);

}
