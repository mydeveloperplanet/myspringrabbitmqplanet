package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverA {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_CONSUMER_A)
    public String receiveMessage(String message) {
        System.out.println("Queue Consumer A received <" + message + ">");

        if (message.equals("This is an rpc message")) {
            return "success";
        } else if (message.equals("This is a timeout message")) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "success";
        } else {
            return "failure";
        }
    }

}
