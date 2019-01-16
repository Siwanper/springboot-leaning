package com.swp.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 创建队列
 *
 * @outhor ios
 * @create 2019-01-15 3:59 PM
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("helloQueue");
    }

    @Bean
    public Queue manyQueue(){
        return new Queue("manyQueue");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("objectQueue");
    }

}
