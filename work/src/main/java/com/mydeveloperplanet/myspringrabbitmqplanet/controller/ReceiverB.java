package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverB {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_TASK)
    public void receiveMessage(String message) {
        System.out.println("Task picked up by Consumer B <" + message + ">");
    }

}
