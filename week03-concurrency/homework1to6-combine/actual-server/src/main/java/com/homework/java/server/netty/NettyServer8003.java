package com.homework.java.server.netty;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 负载均衡server02，监听8002端口
 * <p>
 * 作业06 修改线程池参数
 *
 * @author qiuch
 */
@Slf4j
@Component
public class NettyServer8003 {
    /**
     * 后台服务端口
     */
    public static final int BACKEND_PORT = 8003;
    /**
     * 运行标志位
     */
    public static final AtomicBoolean RUNNING_FLAG = new AtomicBoolean(true);

    private final ExecutorService executorService = new ThreadPoolExecutor(20, 100,
            60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
            new BasicThreadFactory.Builder().namingPattern("server-pool-%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());
    private ServerSocket serverSocket;

    public NettyServer8003() {
        try {
            serverSocket = new ServerSocket(BACKEND_PORT);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void startSocketAccept() {
        while (RUNNING_FLAG.get()) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        // 循环退出之后关闭服务
    }


    @PreDestroy
    public void cleanUp() throws Exception {
        RUNNING_FLAG.set(true);
        serverSocket.close();
        executorService.shutdown();
    }

    private static void service(Socket socket) {
        // TODO - 接收报文-解析Http头
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[8 * 1024];
            int len = inputStream.read(buffer);
            outputStream.write(buffer, 0, len);
            //
            String inputContent = outputStream.toString("UTF-8");
            System.out.println("BackendServer收到请求:\n" + inputContent);
            outputStream.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        //
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio - 8003";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.flush();
            printWriter.close();
            //socket.close();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
    }
}
