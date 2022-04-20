package com.java.homework.dubbohimly.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;


@DubboService(version = "1.0.0")
public class AccountAServiceImpl implements AccountAService {

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void dollar2Rmb() {
        System.out.println("AServiceImpl begin work");
    }

    public void confirm() {
        System.out.println("AServiceImpl confirm");
    }

    public void cancel() {
        System.out.println("AServiceImpl cancel");
    }
}
