package com.java.homework.dubbohimly.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;


@DubboService(version = "1.0.0", weight = 100)
public class AccountBServiceImpl implements AccountBService {

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void rmb2Dollar() {
        System.out.println("BServiceImpl begin work");
    }

    public void confirm() {
        System.out.println("BServiceImpl confirm");
    }

    public void cancel() {
        System.out.println("BServiceImpl cancel");
    }
}
