package com.swp.rabbitmq.tools.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 9:37 AM
 */
@Component
// 监听队列
@RabbitListener(queues = "helloQueue")
public class HelloReciver {
    // 接受消息后处理
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver : " + hello);
    }

}
