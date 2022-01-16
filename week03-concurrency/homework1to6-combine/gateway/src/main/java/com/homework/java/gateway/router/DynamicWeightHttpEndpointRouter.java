package com.homework.java.gateway.router;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 作业04
 * 动态权重路由，初始化权重需要
 *
 * @author qiuch
 */
public class DynamicWeightHttpEndpointRouter implements HttpEndpointRouter {

    private HashMap<String, Integer> urlWeight;
    private int totalWeight = 0;
    private int[] preWeightSum;

    public DynamicWeightHttpEndpointRouter(List<String> urls, List<Integer> weights) throws IllegalArgumentException {
        if (urls.size() != weights.size()) {
            throw new IllegalArgumentException("url&weight list size is not same");
        }
        preWeightSum = new int[urls.size()];
        for (int i = 0; i < urls.size(); i++) {
            urlWeight.put(urls.get(i), weights.get(i));
            totalWeight += weights.get(i);
            preWeightSum[i] = totalWeight;
        }
    }

    @Override
    public String route(List<String> urls) {
        //此处传进来的参数， 需要与初始化后预处理的数据长度一致，因为每次计算效率不高
        // 如果要感知服务状态的变化，可以考虑增加监听来改变初始化的数据
        int randomWeight = new Random(System.currentTimeMillis()).nextInt(totalWeight);
        for (int i = 0; i < urls.size(); i++) {
            if (randomWeight <= preWeightSum[i]) {
                return urls.get(i);
            }
        }
        //默认返回server1
        return urls.get(0);
    }
}
