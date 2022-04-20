package io.kimmking.rpcfx.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;

public class NettyHttpClient {
    //线程组
    private static final EventLoopGroup group = new NioEventLoopGroup();
    //启动类
    private static final Bootstrap bootstrap = new Bootstrap();

    private int PORT;
    private String HOST;

    public NettyHttpClient(int port, String host) {
        this.PORT = port;
        this.HOST = host;
        init();
    }

    private void init() {
        try {
            bootstrap.group(group)
                    .remoteAddress(new InetSocketAddress(HOST, PORT))
                    //长链接
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            //包含编码器和解码器
                            channel.pipeline().addLast(new HttpClientCodec());
                            //聚合
                            channel.pipeline().addLast(new HttpObjectAggregator(1024 * 10 * 1024));
                            //解压
                            channel.pipeline().addLast(new HttpContentDecompressor());
                            channel.pipeline().addLast(new NettyHttpClientHandler());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            group.shutdownGracefully();
//        }
    }

    public void closeClient() {
        group.shutdownGracefully();
    }

    public String postData(String requestParam) throws InterruptedException, UnsupportedEncodingException {
        Channel channel = bootstrap.connect().sync().channel();

        // requestParam = "{\"method\":\"findById\",\"params\":[1],\"serviceClass\":\"io.kimmking.rpcfx.demo.api.UserService\"}";

        //配置HttpRequest的请求数据和一些配置信息
        FullHttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_0, HttpMethod.POST, "/", Unpooled.wrappedBuffer(requestParam.getBytes("UTF-8")));

        request.headers()
                .set(HttpHeaderNames.CONTENT_TYPE, "application/json;charset=utf-8")
                //开启长链接
                .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE)
                //设置传递请求内容的长度
                .set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());

        //发送数据
        channel.writeAndFlush(request);
        NettyHttpClientHandler.resp.put(channel, "wait");
        String result = "";
        while (true) {
            if ("wait".equals(NettyHttpClientHandler.resp.get(channel))) {
                Thread.sleep(50);
                continue;
            }
            result = NettyHttpClientHandler.resp.remove(channel);
            break;
        }

        channel.closeFuture().sync();
        return result;
    }


    public static void main(String[] args) {
        NettyHttpClient c = new NettyHttpClient(8080, "127.0.0.1");
        try {
            System.out.println(c.postData("{\"method\":\"findById\",\"params\":[1],\"serviceClass\":\"io.kimmking.rpcfx.demo.api.UserService\"}"));
            System.out.println(c.postData("{\"method\":\"findById\",\"params\":[2],\"serviceClass\":\"io.kimmking.rpcfx.demo.api.UserService\"}"));
        } catch (InterruptedException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        c.closeClient();
    }

}