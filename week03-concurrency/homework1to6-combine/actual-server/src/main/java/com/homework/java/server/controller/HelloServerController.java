package com.homework.java.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServerController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot server";
    }
}
