package com.swp.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 广播模式交换机
 *
 * @outhor ios
 * @create 2019-01-16 12:11 PM
 */
@Configuration
public class FanoutExchangeConfig {

    // 定义三个队列
    @Bean
    public Queue fanoutOne(){
        return new Queue("fanout.One");
    }

    @Bean
    public Queue fanoutTwo(){
        return new Queue("fanout.Two");
    }

    @Bean
    public Queue fanoutThree(){
        return new Queue("fanout.Three");
    }

    // 定义交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    // 将交换机与队列绑定，绑定了改交换机的队列都会收到消息
    @Bean
    public Binding bindingFanoutOne(Queue fanoutOne, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutOne).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutTwo(Queue fanoutTwo, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutTwo).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutThree(Queue fanoutThree, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutThree).to(fanoutExchange);
    }


}
