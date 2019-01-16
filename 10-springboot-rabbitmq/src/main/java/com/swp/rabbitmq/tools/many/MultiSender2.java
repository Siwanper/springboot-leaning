package com.swp.rabbitmq.tools.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-16 10:44 AM
 */
@Component
public class MultiSender2 {

    @Autowired
    private AmqpTemplate rabbitTempalte;

    public void sender(int i) {
        String context = "spring boot rabbit queue " + " ******* "  + i;
        System.out.println("Sender2 : " + context);
        rabbitTempalte.convertAndSend("manyQueue",context);
    }

}
