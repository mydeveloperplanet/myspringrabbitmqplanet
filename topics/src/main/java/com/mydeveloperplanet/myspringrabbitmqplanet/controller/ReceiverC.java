package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverC {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_CONSUMER_C)
    public void receiveMessage(String message) {
        System.out.println("Queue Consumer C received <" + message + ">");
    }

}
