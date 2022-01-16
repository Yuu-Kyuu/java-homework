package com.homework.java.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * 作业04
 * 静态权重路由，三个之后实例的路由不到
 * 规则来自 HttpEndpointRouter 接口
 *
 * @author qiuch
 */
public class StaticWeightHttpEndpointRouter implements HttpEndpointRouter {

    private final int[] STATIC_WEIGHT = new int[]{20, 30, 50};
    private int weightTotal = 100;

    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        if (size == 2) {
            weightTotal = STATIC_WEIGHT[0] + STATIC_WEIGHT[1];
        }
        if (size == 1) {
            weightTotal = STATIC_WEIGHT[0];
        }
        Random random = new Random(System.currentTimeMillis());
        int randomWeight = random.nextInt(weightTotal);
        //随机数0-20的概率20%，返回server 1
        if (randomWeight <= STATIC_WEIGHT[0]) {
            return urls.get(0);
        }
        //随机数20-50的概率30%，返回server 2
        if (randomWeight <= STATIC_WEIGHT[0] + STATIC_WEIGHT[1]) {
            return urls.get(1);
        }
        //随机数50-100的概率50%，返回server 3
        if (randomWeight <= STATIC_WEIGHT[0] + STATIC_WEIGHT[1] + STATIC_WEIGHT[2]) {
            return urls.get(2);
        }
        //默认返回server1
        return urls.get(0);
    }
}
