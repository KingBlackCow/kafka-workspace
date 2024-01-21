package com.example.kafkaworkspace;

import com.example.kafkaworkspace.producer.Producer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class KafkaWorkspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaWorkspaceApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(Producer producer) {
        return args -> {
            //kafkaTemplate.send("producer_topic", "hello, hi");
//            producer.async("producer_topic", "hello, async");
//            producer.sync("producer_topic", "hello, sync");
            producer.routingSend("producer_topic", "Hello, routing");
            producer.routingSendBytes("producer_route_topic", "Hello, Bytes".getBytes(StandardCharsets.UTF_8));
            producer.replyingSend("request", "Ping");
            Thread.sleep(1000L);
        };
    }
}
