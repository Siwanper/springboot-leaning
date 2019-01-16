package com.swp.rabbitmq.tools.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 12:17 PM
 */
@Component
@RabbitListener(queues = "fanout.Three")
public class FanoutReceiver3 {

    @RabbitHandler
    public void process(String message){
        System.out.println("fanoutThree Receiver : " + message);
    }

}
