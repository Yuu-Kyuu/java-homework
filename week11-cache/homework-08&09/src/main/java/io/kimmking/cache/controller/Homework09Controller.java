package io.kimmking.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author qiucihang
 */
@RestController
public class Homework09Controller {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    private final String QUEUE_NAME = "pub_sub_queue";

    @RequestMapping("/pub")
    String pub(@RequestParam("msg") String msg) {
        redisTemplate.convertAndSend("order_topic", msg);
        return "message:[" + msg + "] send success";
    }


}
