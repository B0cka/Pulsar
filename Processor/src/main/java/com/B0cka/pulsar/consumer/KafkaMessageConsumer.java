package com.B0cka.pulsar.consumer;

import com.B0cka.pulsar.models.KafkaMessage;
import com.B0cka.pulsar.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageConsumer {

    private final MessageRepository messageRepository;

    // Теперь метод слушает сообщения типа KafkaMessage (а не MessageRequest)
    @KafkaListener(topics = "pulsar.messages", groupId = "pulsar-processor-group")
    public void listen(KafkaMessage kafkaMessage) { // Принимаем KafkaMessage!
        log.info("Получил из Kafka: '{}', ID: {}", kafkaMessage.getText(), kafkaMessage.getMessageId());

        KafkaMessage entity = new KafkaMessage();
        entity.setText(kafkaMessage.getText());
        entity.setMessageId(kafkaMessage.getMessageId());
        entity.setCreatedAt(Instant.now());

        messageRepository.save(entity);
        log.info("Сохранил в БД с ID: {}", entity.getId());
    }
}