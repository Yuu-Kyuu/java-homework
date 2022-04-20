package com.java.homework.dubbohimly.consumer.controller;

import com.java.homework.dubbohimly.service.AccountBService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountBController {
    @DubboReference(version = "1.0.0")
    private AccountBService accountBService;

    @GetMapping("transfer/b")
    public String transfer() {
        accountBService.rmb2Dollar();
        return "success";
    }
}
