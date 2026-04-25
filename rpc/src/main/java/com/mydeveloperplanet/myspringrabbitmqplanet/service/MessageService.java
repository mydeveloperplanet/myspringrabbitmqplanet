package com.mydeveloperplanet.myspringrabbitmqplanet.service;

import static com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig.ROUTING_KEY_RPC_MESSAGE;

import java.util.concurrent.CompletableFuture;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;

import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private RabbitTemplate rabbitTemplate;

    private AsyncRabbitTemplate asyncRabbitTemplate;

    public MessageService(RabbitTemplate rabbitTemplate, AsyncRabbitTemplate asyncRabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.asyncRabbitTemplate = asyncRabbitTemplate;
    }

    public void sendMessage(String message) {
        Object response = rabbitTemplate.convertSendAndReceive(RabbitMqConfig.DIRECT_EXCHANGE_NAME, ROUTING_KEY_RPC_MESSAGE, message);
        if (response != null) {
            System.out.println("Sender received response: " + response);
        } else {
            System.out.println("No response received");
        }
    }

    public void sendAsyncMessage(String message) {
        CompletableFuture<Object> future = asyncRabbitTemplate.convertSendAndReceive(RabbitMqConfig.DIRECT_EXCHANGE_NAME, ROUTING_KEY_RPC_MESSAGE, message);

        future.thenAccept(response -> {
            if (response != null) {
                System.out.println("Sender received response: " + response);
            } else {
                System.out.println("No response received");
            }
        });

    }

}
