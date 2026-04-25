package com.mydeveloperplanet.myspringrabbitmqplanet.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE_TASK = "task.queue";

    @Bean
    public Queue queueTask() {
        return new Queue(QUEUE_TASK, false);
    }

}
