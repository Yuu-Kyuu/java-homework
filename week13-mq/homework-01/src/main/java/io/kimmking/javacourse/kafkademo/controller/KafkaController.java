package io.kimmking.javacourse.kafkademo.controller;


import io.kimmking.javacourse.kafkademo.component.KafkaProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaProvider kafkaProvider;

    @GetMapping("/msg/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        kafkaProvider.sendMsg("homeworktopic", msg);
        return "success";
    }
}
