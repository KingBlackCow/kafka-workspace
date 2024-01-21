package com.example.kafkaworkspace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

public class KafkaProducerConfig {
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("producer_topic").build(),
                TopicBuilder.name("request").build(),
                TopicBuilder.name("replies").build()
        );
    }
}
