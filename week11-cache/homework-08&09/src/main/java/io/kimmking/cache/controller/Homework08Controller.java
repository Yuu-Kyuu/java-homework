package io.kimmking.cache.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class Homework08Controller {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    private final String COUNT_KEY = "count_key";

    @RequestMapping("/lock")
    String lock(@RequestParam("lockId") Integer lockId) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent("lock" + lockId, lockId, 1, TimeUnit.HOURS);
        return success != null && success ? "lock success" : "lock fail";
    }

    @RequestMapping("/unlock")
    String unlock(@RequestParam("lockId") Integer lockId) {

        List<Object> redisResult = redisTemplate.execute(new SessionCallback<List<Object>>() {

            @Override
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                Object currLockId = redisTemplate.opsForValue().get("lock" + lockId);
                redisTemplate.multi();
                if (lockId.equals(currLockId)) {
                    redisTemplate.delete("lock" + lockId);
                }
                return redisTemplate.exec();
            }
        });
        if (redisResult != null && !redisResult.isEmpty() && redisResult.get(0).equals(Boolean.TRUE)) {
            return "unlock success";
        }
        return "unlock fail";
    }

    @RequestMapping("/count/init")
    String countInit(@RequestParam("total") Integer total) {
        if (total < 0) {
            return "total must be positive";
        }
        redisTemplate.opsForValue().set(COUNT_KEY, total, 1, TimeUnit.HOURS);
        return "total now is " + total;
    }

    @RequestMapping("/count/reduceOne")
    String countReduce() {
        Long remain = redisTemplate.opsForValue().increment(COUNT_KEY, -1L);
        if (remain == null || remain < 0) {
            return "reduceOne fail, nothing left";
        } else {
            return "current count" + remain;
        }
    }


    @RequestMapping("/count/test")
    String countReduceTest() {
        CyclicBarrier b = new CyclicBarrier(20);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    b.await();
                    System.out.println(countReduce());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        return "";
    }

}
