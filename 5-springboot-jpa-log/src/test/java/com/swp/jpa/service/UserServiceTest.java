package com.swp.jpa.service;

import com.swp.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-09 11:09 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void getAllUser(){
        List<User> users = repository.findAll();
        System.out.println(users);
    }



}


