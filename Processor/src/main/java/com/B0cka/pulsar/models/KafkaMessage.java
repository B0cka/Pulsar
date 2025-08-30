package com.B0cka.pulsar.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "messages")
@Data
public class KafkaMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String messageId;
    private Instant createdAt;

}