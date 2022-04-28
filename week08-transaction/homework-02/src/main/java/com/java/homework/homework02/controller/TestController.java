package com.java.homework.homework02.controller;

import com.java.homework.homework02.service.OrderService;
import com.java.homework.homework02.service.OrderTranstractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shadingshpere")
public class TestController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderTranstractionService orderTranstractionService;

    @PutMapping("/create")
    public String insert() {
        orderService.testInsert();
        return "success";
    }

    @GetMapping("/read")
    public String select(@RequestParam("orderId") Long orderId) {
        Object result = orderService.testSelect(orderId);
        return result == null ? "empty" : result.toString();
    }

    @PostMapping("/update")
    public String update(@RequestParam("orderId") Long orderId) {
        orderService.testUpdate(orderId);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("orderId") Long orderId) {
        orderService.testDelete(orderId);
        return "success";
    }


    @GetMapping("/tx")
    public String tx() {
        orderTranstractionService.xaTest();
        return "success";
    }
}
