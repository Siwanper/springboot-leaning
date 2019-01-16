package com.swp.rabbitmq.tools.object;

import com.swp.rabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 11:15 AM
 */
@Component
@RabbitListener(queues = "objectQueue")
public class ObjectReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("objectReceiver : " + user);
    }

}
