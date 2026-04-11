package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverB {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_CONSUMER_B)
    public void receiveMessage(String message) {
        System.out.println("Queue Consumer B received <" + message + ">");
    }

}
