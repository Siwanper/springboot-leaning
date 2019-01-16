package com.swp.rabbitmq;

import com.swp.rabbitmq.tools.many.MultiSender1;
import com.swp.rabbitmq.tools.many.MultiSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 10:49 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private MultiSender1 sender1;

    @Autowired
    private MultiSender2 sender2;

    @Test
    public void oneToMany(){

        for (int i = 0; i < 100; i++) {
            sender1.sender(i);
        }
    }

    @Test
    public void manyToMany(){

        for (int i = 0; i < 100; i++) {
            sender1.sender(i);
            sender2.sender(i);
        }
    }

}
