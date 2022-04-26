package com.java.homework.weekseven.controller.generate;

import com.java.homework.weekseven.data.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateDataController {

    @Autowired
    OrderService orderService;


    //循环插入
    @GetMapping("/generateMillionData")
    public String generateMillionData() {
        long start = System.currentTimeMillis();
        orderService.insertRandomOrderData(100000);
        return "UseTime:" + (System.currentTimeMillis() - start);
    }

    //批量插入
    @GetMapping("/generateMillionDataBatch")
    public String generateMillionDataBatch() {
        long start = System.currentTimeMillis();
        orderService.insertRandomOrderDataBatch(100000);
        return "UseTime:" + (System.currentTimeMillis() - start);
    }

    //批量插入
    @GetMapping("/generateMillionDataSQLBatch")
    public String generateMillionDataSQLBatch() {
        long start = System.currentTimeMillis();
        orderService.insertSQLBatchs(100000);
        return "UseTime:" + (System.currentTimeMillis() - start);
    }

    //批量插入values
    @GetMapping("/generateMillionDataValues")
    public String generateMillionDataValues() {
        long start = System.currentTimeMillis();
        orderService.insertSQLValues(100000);
        return "UseTime:" + (System.currentTimeMillis() - start);
    }
}
