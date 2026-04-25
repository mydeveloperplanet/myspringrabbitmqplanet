package com.mydeveloperplanet.myspringrabbitmqplanet.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE_CONSUMER_A = "consumer-a.queue";
    public static final String DIRECT_EXCHANGE_NAME = "events.exchange";
    public static final String ROUTING_KEY_RPC_MESSAGE = "event.rpc";

    @Bean
    DirectExchange eventsExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue queueConsumerA() {
        return new Queue(QUEUE_CONSUMER_A, false);
    }

    @Bean
    Binding bindingConsumerA(Queue queueConsumerA, DirectExchange exchange) {
        return BindingBuilder.bind(queueConsumerA).to(exchange).with(ROUTING_KEY_RPC_MESSAGE);
    }

    @Bean
    public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate) {
        return new AsyncRabbitTemplate(rabbitTemplate);
    }

}
