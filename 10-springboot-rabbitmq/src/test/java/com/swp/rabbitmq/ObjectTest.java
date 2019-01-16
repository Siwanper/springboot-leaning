package com.swp.rabbitmq;

import com.swp.rabbitmq.model.User;
import com.swp.rabbitmq.tools.hello.HelloSender;
import com.swp.rabbitmq.tools.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-15 4:09 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender sender;

    @Test
    public void test() {
        User user = new User();
        user.setName("史万鹏");
        user.setPass("1111");
        sender.send(user);
//        Thread.sleep(1000);
    }

}
