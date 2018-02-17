package com.fparareda.messages.controller;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.messages.model.Message;
import com.fparareda.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @PutMapping("/{marsRoverId}")
    @PreAuthorize("hasAuthority('STANDARD_USER')")
    public Message transmit(@Valid @PathVariable long marsRoverId, @Valid @RequestBody Message message) throws EntityNotFoundException {
        return messageService.transmitMessage(marsRoverId, message);
    }
}
