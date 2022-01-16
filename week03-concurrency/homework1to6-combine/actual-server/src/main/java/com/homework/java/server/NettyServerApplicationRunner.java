package com.homework.java.server;


import com.homework.java.server.netty.NettyServer8002;
import com.homework.java.server.netty.NettyServer8003;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Springboot 启动完成后再开启netty的监听
 * 不然直接进入死循环监听
 *
 * @author qiuch
 */
@Component
public class NettyServerApplicationRunner implements ApplicationRunner {
    @Autowired
    NettyServer8002 nettyServer8002;

    @Autowired
    NettyServer8003 nettyServer8003;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("netty server start");
        new Thread(() -> {
            nettyServer8002.startSocketAccept();
        }).start();
        new Thread(() -> {
            nettyServer8003.startSocketAccept();
        }).start();
    }
}