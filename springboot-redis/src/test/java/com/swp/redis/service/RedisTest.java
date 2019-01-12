package com.swp.redis.service;

import com.swp.redis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-12 3:17 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("a", "111");
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);
    }

    @Test
    public void objectTest(){
        User user = new User("zhangsan",21);
        user.setId(UUID.randomUUID().toString());
        redisTemplate.opsForValue().set("user",user);

        User rUser = (User) redisTemplate.opsForValue().get("user");
        System.out.println(rUser);
    }

}
