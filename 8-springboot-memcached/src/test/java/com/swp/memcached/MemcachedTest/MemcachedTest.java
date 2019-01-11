package com.swp.memcached.MemcachedTest;

import com.swp.memcached.model.User;
import com.whalin.MemCached.MemCachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-11 5:13 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedTest {

    @Autowired
    private MemCachedClient memCachedClient;

    @Test
    public void test() throws InterruptedException {
        memCachedClient.set("a","123");
        String value = (String) memCachedClient.get("a");
        System.out.println(value);

        // 3s后过期
        memCachedClient.set("b",1, new Date(3000));
        Object flag =  memCachedClient.get("b");
        System.out.println(flag);

        Thread.sleep(3000);
        flag = memCachedClient.get("b");
        System.out.println(flag);
    }

    @Test
    public void addUser(){
        User user = new User("史万鹏", "123456");

        memCachedClient.set("user", user);

        User cUser = (User) memCachedClient.get("user");
        System.out.println(cUser);
    }

}
