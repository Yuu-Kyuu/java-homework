package com.homework.java.gateway.outbound.httpclient4;

import com.homework.java.gateway.filter.HeaderHttpResponseFilter;
import com.homework.java.gateway.filter.HttpRequestFilter;
import com.homework.java.gateway.filter.HttpResponseFilter;
import com.homework.java.gateway.filter.ProxyBizResponseFilter;
import com.homework.java.gateway.router.HttpEndpointRouter;
import com.homework.java.gateway.router.StaticWeightHttpEndpointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * 作业01
 * 修改上周的作业，代理访问后端服务
 * <p>
 * 作业04
 * 加入了路由策略
 *
 * @author qiuch
 */
public class HttpOutboundHandlerFromLastWeek {
    List<String> actualServerList;

    public HttpOutboundHandlerFromLastWeek(List<String> actualServerList) {
        this.actualServerList = actualServerList;
    }

    HttpResponseFilter filter = new ProxyBizResponseFilter();
    HttpEndpointRouter router = new StaticWeightHttpEndpointRouter();


    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter) {
        String backendUrl = router.route(this.actualServerList);
        final String url = backendUrl + fullRequest.uri();
        filter.filter(fullRequest, ctx);
        //proxyService.submit(() -> fetchGet(fullRequest, ctx, url));
        //此处替换成上周自己的httpclient实现
        String serverResponse = proxyRequest(url);

        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
                Unpooled.wrappedBuffer(serverResponse.getBytes(StandardCharsets.UTF_8)));
        ctx.write(response).addListener(ChannelFutureListener.CLOSE);
        ctx.flush();
    }

    public String proxyRequest(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGetActualServer = new HttpGet(url);

        ResponseHandler<String> responseHandler = httpResponse -> {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = httpResponse.getEntity();
                return entity == null ? "EMPTY BODY" : EntityUtils.toString(entity);
            } else {
                return "ERROE: STATUS CODE " + statusCode;
            }
        };

        String response = "";
        try {
            response = client.execute(httpGetActualServer, responseHandler);
            client.close();
        } catch (IOException e) {
            return "ERROE: " + e.getMessage();
        }

        return response;
    }
}
