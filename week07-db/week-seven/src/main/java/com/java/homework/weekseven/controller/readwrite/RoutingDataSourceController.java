package com.java.homework.weekseven.controller.readwrite;

import com.java.homework.weekseven.data.service.ReadWriteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoutingDataSourceController {
    @Autowired
    ReadWriteOrderService orderService;

    @GetMapping("/write")
    public String generateMillionData() {
        Long orderId = orderService.insertNewOrder();
        return String.valueOf(orderId);
    }

    @GetMapping("/read")
    public String generateMillionData(@RequestParam("orderId") Long orderId) {
        return String.valueOf(orderService.selectById(orderId));
    }
}
