package com.mydeveloperplanet.myspringrabbitmqplanet.config;


import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String FANOUT_EXCHANGE_NAME = "fanout.exchange";

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE_NAME);
    }

    @Bean
    public Queue queueConsumerA() {
        return new AnonymousQueue();
    }

    @Bean
    Binding bindingConsumerA(Queue queueConsumerA, FanoutExchange exchange) {
        return BindingBuilder.bind(queueConsumerA).to(exchange);
    }

    @Bean
    public Queue queueConsumerB() {
        return new AnonymousQueue();
    }

    @Bean
    Binding bindingConsumerBGeneral(Queue queueConsumerB, FanoutExchange exchange) {
        return BindingBuilder.bind(queueConsumerB).to(exchange);
    }

    @Bean
    Binding bindingConsumerBSpecific(Queue queueConsumerB, FanoutExchange exchange) {
        return BindingBuilder.bind(queueConsumerB).to(exchange);
    }

}
