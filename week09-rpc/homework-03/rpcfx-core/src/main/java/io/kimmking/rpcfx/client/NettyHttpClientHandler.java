package io.kimmking.rpcfx.client;


import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class NettyHttpClientHandler extends ChannelInboundHandlerAdapter {

    public static Map<Channel, String> resp = new ConcurrentHashMap<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response = (FullHttpResponse) msg;
        ByteBuf content = response.content();
        //System.out.println(content.toString(CharsetUtil.UTF_8));
        resp.put(ctx.pipeline().channel(), content.toString(CharsetUtil.UTF_8));
    }


}