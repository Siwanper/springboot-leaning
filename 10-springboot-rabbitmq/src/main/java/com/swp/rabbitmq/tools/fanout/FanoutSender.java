package com.swp.rabbitmq.tools.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 12:17 PM
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        // 参数1：交换机
        // 参数2：routing_key
        // 参数3：消息，可以是对象
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

}
