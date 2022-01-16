package com.homework.java.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * 作业03
 * 参照git样例代码实现Filter
 *
 * @author qiuch
 */
public class ProxyBizResponseFilter implements HttpResponseFilter {

    public static ProxyBizResponseFilter newInstance() {
        return new ProxyBizResponseFilter();
    }


    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("java-homework", "java-1-nio");
    }
}