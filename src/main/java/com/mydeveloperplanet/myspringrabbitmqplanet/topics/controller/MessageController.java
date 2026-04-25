package com.mydeveloperplanet.myspringrabbitmqplanet.topics.controller;

import com.mydeveloperplanet.myspringrabbitmqplanet.topics.service.MessageService;

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
            value = "send-general"
    )
    public ResponseEntity<Void> sendGeneralMessage(@RequestBody String message) {
        messageService.sendMessage("event.general.message", message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "send-specific"
    )
    public ResponseEntity<Void> sendSpecificMessage(@RequestBody String message) {
        messageService.sendMessage("event.specific.message", message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "send-nested-general"
    )
    public ResponseEntity<Void> sendNestedGeneralMessage(@RequestBody String message) {
        messageService.sendMessage("event.general.message.nested", message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
