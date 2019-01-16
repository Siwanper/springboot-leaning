package com.swp.rabbitmq.tools.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 10:47 AM
 */
@Component
@RabbitListener(queues = "manyQueue")
public class MultiReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver1 : " + message);
    }

}