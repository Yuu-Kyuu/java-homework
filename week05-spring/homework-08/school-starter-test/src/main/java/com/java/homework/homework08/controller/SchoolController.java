package com.java.homework.homework08.controller;

import com.java.homework.homework08.starter.service.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    @Autowired
    School school;

    @GetMapping("/school")
    public String schoolTest() {
        school.ding();
        return school.toString();
    }
}
