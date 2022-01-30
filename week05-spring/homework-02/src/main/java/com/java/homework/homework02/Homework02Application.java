package com.java.homework.homework02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:xml/bean.xml")
public class Homework02Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework02Application.class, args);
    }

}
