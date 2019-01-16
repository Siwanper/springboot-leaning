package com.swp.rabbitmq;

import com.swp.rabbitmq.tools.topic.TopicSender;
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
public class TopicTest {

    @Autowired
    private TopicSender sender;

    @Test
    public void test() {
        sender.send();
//        Thread.sleep(1000);
    }

    @Test
    public void test1() {
        sender.send1();
//        Thread.sleep(1000);
    }

    @Test
    public void test2() {
        sender.send2();
//        Thread.sleep(1000);
    }

}
