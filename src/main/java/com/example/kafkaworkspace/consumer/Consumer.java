package com.example.kafkaworkspace.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Date;


@Service
public class Consumer {

//    @KafkaListener(id = "producer-topic-id", topics = "producer_topic")
//    public void listenClip3(String message) {
//        System.out.println(message);
//    }
//
//    @KafkaListener(id = "producer-route_topic-bytes-id", topics = "producer_route_topic")
//    public void listenClip3Bytes(String message) {
//        System.out.println(message);
//    }
//
//    @KafkaListener(id = "producer-request-id", topics = "request")
//    @SendTo
//    public String listenClipRequest(String message) {
//        System.out.println(message);
//        return "Pong";
//    }

    @KafkaListener(id = "clip4-listener-id", topics = "consumer-listener")
    public void listen(String message,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       ConsumerRecordMetadata metadata) {
        System.out.println("Listener. offset=" + metadata.offset() +
                ", partition=" + partition +
                ", timestamp=" + new Date(timestamp) +
                ", message=" + message
        );
    }
}