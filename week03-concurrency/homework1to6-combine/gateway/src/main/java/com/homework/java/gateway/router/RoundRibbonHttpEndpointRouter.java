package com.homework.java.gateway.router;

import java.util.List;

/**
 * 作业04
 * 路由轮询
 *
 * @author qiuch
 */
public class RoundRibbonHttpEndpointRouter implements HttpEndpointRouter {

    private static int callCount = 0;

    @Override
    public String route(List<String> urls) {
        callCount++;
        int size = urls.size();
        //避免取模数太大
        if (callCount >= size * 100) {
            callCount = 0;
        }
        return urls.get(callCount % urls.size());
    }
}
