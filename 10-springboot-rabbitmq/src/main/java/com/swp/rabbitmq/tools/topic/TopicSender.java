package com.swp.rabbitmq.tools.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 11:51 AM
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "topic message";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange","topic.1", context);
    }

    public void send1(){
        String context = "topic message";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange","topic.message", context);
    }

    public void send2(){
        String context = "topic message";
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("exchange","topic.messages", context);
    }

}
