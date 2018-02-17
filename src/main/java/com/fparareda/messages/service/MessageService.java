package com.fparareda.messages.service;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.messages.model.Message;

public interface MessageService {
    Message transmitMessage(long marsRoverId, Message message) throws EntityNotFoundException;
}
