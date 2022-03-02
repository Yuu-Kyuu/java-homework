package com.java.homework.weekseven.controller.generate;

import com.java.homework.weekseven.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class generateDataController {

    @Autowired
    OrderService orderService;

    @GetMapping("/generateMillionData")
    public String generateMillionData() {
        long start = System.currentTimeMillis();
        orderService.insertRandomOrderData(1000000);
        return "UseTime:" + (System.currentTimeMillis() - start);
    }
}
