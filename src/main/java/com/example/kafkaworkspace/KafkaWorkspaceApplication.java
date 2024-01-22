package com.example.kafkaworkspace;

import com.example.kafkaworkspace.producer.Producer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaWorkspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaWorkspaceApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(Producer producer) {
        return args -> {
            producer.async("consumer-listener", "Hello,  Container");
        };
    }
}
