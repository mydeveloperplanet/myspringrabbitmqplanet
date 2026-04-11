package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverA {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_CONSUMER_A)
    public void receiveMessage(String message) {
        System.out.println("Queue Consumer A received <" + message + ">");
    }

}
