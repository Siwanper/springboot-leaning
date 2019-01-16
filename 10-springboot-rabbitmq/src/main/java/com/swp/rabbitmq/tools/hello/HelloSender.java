package com.swp.rabbitmq.tools.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 9:34 AM
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "helloQueue " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("helloQueue", context);
    }

}
