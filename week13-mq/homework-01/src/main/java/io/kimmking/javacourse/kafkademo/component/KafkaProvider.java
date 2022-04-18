package io.kimmking.javacourse.kafkademo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProvider {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息到kafka
     *
     * @param topic   主题
     * @param message 内容体
     */
    public void sendMsg(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}