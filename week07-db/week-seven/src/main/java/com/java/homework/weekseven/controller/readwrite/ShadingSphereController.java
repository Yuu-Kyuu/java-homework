package com.java.homework.weekseven.controller.readwrite;

import com.java.homework.weekseven.data.service.ShadingSphereOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShadingSphereController {
    @Autowired
    ShadingSphereOrderService orderService;

    @GetMapping("/shadingSphere/write")
    public String generateMillionData() {
        Long orderId = orderService.insertNewOrder();
        return String.valueOf(orderId);
    }

    @GetMapping("/shadingSphere/read")
    public String generateMillionData(@RequestParam("orderId") Long orderId) {
        return String.valueOf(orderService.selectById(orderId));
    }
}
