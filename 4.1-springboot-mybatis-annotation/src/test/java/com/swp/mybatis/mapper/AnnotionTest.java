package com.swp.mybatis.mapper;

import com.swp.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-08 10:13 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotionTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void getAllUser(){
        List<User> users = mapper.getAllUser();
        System.out.println(users);
    }

    @Test
    public void getUser(){
        User user = mapper.getUser(3);
        System.out.println(user);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserName("王杰");
        user.setUserPassword("123456546313154546");
        user.setUserSex('2');
        user.setUserBirthday(new Date());

        int result = mapper.insertUser(user);
        System.out.println(result);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUid(3);
        user.setUserName("刘冷");

        int result = mapper.updateUser(user);
        System.out.println(result);
    }

}
