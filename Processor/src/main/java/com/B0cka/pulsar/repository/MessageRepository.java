package com.B0cka.pulsar.repository;

import com.B0cka.pulsar.models.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<KafkaMessage, Long> {
}