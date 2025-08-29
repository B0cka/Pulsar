package com.B0cka.pulsar.impl;

import com.B0cka.pulsar.dto.MessageRequest;
import com.B0cka.pulsar.service.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceImpl implements WebService {

    private final KafkaTemplate<String, MessageRequest> kafkaTemplate;

    @Override
    public void createMessage(MessageRequest messageRequest) {
        log.info("Отправка сообщения в Kafka: '{}'", messageRequest.getText());

        kafkaTemplate.send("pulsar.messages", messageRequest);
    }
}