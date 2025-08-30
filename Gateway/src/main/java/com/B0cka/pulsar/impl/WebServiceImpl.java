package com.B0cka.pulsar.impl;

import com.B0cka.pulsar.dto.MessageRequest;
import com.B0cka.pulsar.models.KafkaMessage;
import com.B0cka.pulsar.service.WebService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebServiceImpl implements WebService {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Override
    public void createMessage(MessageRequest messageRequest) {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setText(messageRequest.getText());
        kafkaMessage.setMessageId(UUID.randomUUID().toString());

        log.info("Отправка в Kafka: '{}', ID: {}", kafkaMessage.getText(), kafkaMessage.getMessageId());

        kafkaTemplate.send("pulsar.messages", kafkaMessage);
    }
}