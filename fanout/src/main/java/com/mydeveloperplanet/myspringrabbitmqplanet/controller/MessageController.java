package com.mydeveloperplanet.myspringrabbitmqplanet.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.config.RabbitMqConfig;
import com.mydeveloperplanet.myspringrabbitmqplanet.service.MessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "send-to-all"
    )
    public ResponseEntity<Void> sendGeneralMessage(@RequestBody String message) {
        messageService.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
