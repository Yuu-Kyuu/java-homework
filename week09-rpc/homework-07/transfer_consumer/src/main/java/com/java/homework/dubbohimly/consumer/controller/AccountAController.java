package com.java.homework.dubbohimly.consumer.controller;

import com.java.homework.dubbohimly.service.AccountAService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAController {
    @DubboReference(version = "1.0.0")
    private AccountAService accountAService;

    @GetMapping("transfer/a")
    public String transfer() {
        accountAService.dollar2Rmb();
        return "success";
    }
}
