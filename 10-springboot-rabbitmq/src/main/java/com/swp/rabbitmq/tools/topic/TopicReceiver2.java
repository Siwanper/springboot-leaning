package com.swp.rabbitmq.tools.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 11:57 AM
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver2 : " + message);
    }

}
