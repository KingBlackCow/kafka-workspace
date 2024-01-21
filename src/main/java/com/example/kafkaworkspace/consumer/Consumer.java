package com.example.kafkaworkspace.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(id = "producer-topic-id", topics = "producer_topic")
    public void listenClip3(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "producer-route_topic-bytes-id", topics = "producer_route_topic")
    public void listenClip3Bytes(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "producer-request-id", topics = "request")
    @SendTo
    public String listenClipRequest(String message) {
        System.out.println(message);
        return "Pong";
    }
}