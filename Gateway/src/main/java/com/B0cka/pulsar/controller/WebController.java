package com.B0cka.pulsar.controller;

import com.B0cka.pulsar.dto.MessageRequest;
import com.B0cka.pulsar.service.WebService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
public class WebController {

    private final WebService webService;

    @PostMapping("/message")
    public ResponseEntity<String> createMessage(@Valid @RequestBody MessageRequest messageRequest) {
        log.info("Получение сообщения с текстом: {}", messageRequest.getText());
        webService.createMessage(messageRequest);
        return ResponseEntity.accepted().body("Сообщение принято в обработку");
    }
}