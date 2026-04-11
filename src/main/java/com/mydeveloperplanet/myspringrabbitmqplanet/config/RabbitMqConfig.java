package com.mydeveloperplanet.myspringrabbitmqplanet.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE_CONSUMER_A = "consumer-a.queue";
    public static final String QUEUE_CONSUMER_B = "consumer-b.queue";
    public static final String TOPIC_EXCHANGE_NAME = "events.exchange";
    public static final String ROUTING_KEY_GENERAL_MESSAGE = "event.general.*";
    public static final String ROUTING_KEY_SPECIFIC_MESSAGE = "event.specific.*";

    @Bean
    TopicExchange eventsExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Queue queueConsumerA() {
        return new Queue(QUEUE_CONSUMER_A, false);
    }

    @Bean
    Binding bindingConsumerA(Queue queueConsumerA, TopicExchange exchange) {
        return BindingBuilder.bind(queueConsumerA).to(exchange).with(ROUTING_KEY_GENERAL_MESSAGE);
    }

    @Bean
    public Queue queueConsumerB() {
        return new Queue(QUEUE_CONSUMER_B, false);
    }

    @Bean
    Binding bindingConsumerBGeneral(Queue queueConsumerB, TopicExchange exchange) {
        return BindingBuilder.bind(queueConsumerB).to(exchange).with(ROUTING_KEY_GENERAL_MESSAGE);
    }

    @Bean
    Binding bindingConsumerBSpecific(Queue queueConsumerB, TopicExchange exchange) {
        return BindingBuilder.bind(queueConsumerB).to(exchange).with(ROUTING_KEY_SPECIFIC_MESSAGE);
    }

}
