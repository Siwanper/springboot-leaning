package com.swp.mybatisxml.mapper;

import com.swp.mybatisxml.model.User;
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
 * @create 2019-01-08 11:41 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XMLTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserList(){
        List<User> users = userMapper.getAllUser();
        System.out.println(users);
    }

    @Test
    public void getUser(){
        User user = userMapper.getUser(4);
        System.out.println(user);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserName("王杰");
        user.setUserPassword("123456546313154546");
        user.setUserSex('2');
        user.setUserBirthday(new Date());

        int result = userMapper.insertUser(user);
        System.out.println(result);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUid(5);
        user.setUserName("刘冷");

        int result = userMapper.updateUser(user);
        System.out.println(result);
    }

    @Test
    public void deleteUser(){
        int result = userMapper.deleteUser(4);
        System.out.println(result);
    }

}
