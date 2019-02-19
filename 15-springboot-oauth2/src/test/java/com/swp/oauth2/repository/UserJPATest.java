package com.swp.oauth2.repository;

import com.swp.oauth2.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-19 3:30 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJPATest {

    @Autowired
    private UserJPA userJPA;

    @Test
    public void test(){

        List<User> all = userJPA.findAll();
        System.out.println(all);

    }

    @Test
    public void test1(){

        User user = userJPA.findByUsername("admin");
        System.out.println(user);

    }

    @Test
    public void test2(){

        User user = userJPA.findByUsernameCaseInsensitive("admin");
        System.out.println(user);

    }

    @Test
    public void password(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }


}
