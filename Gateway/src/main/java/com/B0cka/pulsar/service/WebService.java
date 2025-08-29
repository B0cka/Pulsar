package com.B0cka.pulsar.service;

import com.B0cka.pulsar.dto.MessageRequest;

public interface WebService {

    void createMessage(MessageRequest messageRequest);

}
