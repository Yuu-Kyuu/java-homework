package io.kimmking.javacourse.kafkademo.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"homeworktopic"})
    public void receive(String message) {
        System.out.println("homeworktopic message:" + message);
    }
}