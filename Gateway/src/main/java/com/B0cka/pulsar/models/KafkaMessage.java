package com.B0cka.pulsar.models;

import lombok.Data;

@Data
public class KafkaMessage {
    private String text;
    private String messageId;
}