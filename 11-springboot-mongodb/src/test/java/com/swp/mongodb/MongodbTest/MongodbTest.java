package com.swp.mongodb.MongodbTest;

import com.swp.mongodb.model.User;
import com.swp.mongodb.service.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-18 5:29 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void add(){

        User user = new User();
        user.setId(1l);
        user.setUserName("zhangsan");
        user.setPassWord("123");

        userDao.saveUser(user);

    }

}
