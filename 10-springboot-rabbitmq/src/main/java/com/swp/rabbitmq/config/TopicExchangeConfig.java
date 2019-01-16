package com.swp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: routing_key 模式
 *
 * @outhor ios
 * @create 2019-01-16 11:43 AM
 */
@Configuration
public class TopicExchangeConfig {

    private static final String message = "topic.message";
    private static final String messages = "topic.messages";

    // 创建两个队列
    @Bean
    public Queue queueMessage(){
        return new Queue(TopicExchangeConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicExchangeConfig.messages);
    }

    // topic 交换机，可以根据routing_key自由的绑定不同的队列
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange");
    }

    // 将队列与交换机，根据不同的路由模式（规则） routing_key  绑定在一起
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
