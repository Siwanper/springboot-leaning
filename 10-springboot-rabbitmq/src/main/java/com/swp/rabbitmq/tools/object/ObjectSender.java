package com.swp.rabbitmq.tools.object;

import com.swp.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 11:13 AM
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user){
        System.out.println("objectSender : " + user.toString());
        rabbitTemplate.convertAndSend("objectQueue", user);
    }

}
