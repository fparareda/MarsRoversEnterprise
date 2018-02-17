package com.fparareda.messages.service.impl;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.service.MarsRoversService;
import com.fparareda.messages.model.Message;
import com.fparareda.messages.repository.MessageRepository;
import com.fparareda.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;
    private MarsRoversService marsRoversService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, MarsRoversService marsRoversService) {
        this.messageRepository = messageRepository;
        this.marsRoversService = marsRoversService;
    }

    @Override
    public Message transmitMessage(long marsRoverId, Message message) throws EntityNotFoundException {
        message.assignMarsRover(marsRoversService.find(marsRoverId));
        return messageRepository.save(message);
    }
}
