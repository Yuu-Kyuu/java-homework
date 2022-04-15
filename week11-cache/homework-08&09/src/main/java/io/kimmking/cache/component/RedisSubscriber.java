package io.kimmking.cache.component;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author qiucihang
 */
@Component
public class RedisSubscriber extends MessageListenerAdapter {


    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(" topic :[" + new String(bytes) + "] received message :[" + message + "] ");
    }

}