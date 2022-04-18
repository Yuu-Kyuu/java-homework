package io.kimmking.kmq.core.v2;

import io.kimmking.kmq.core.KmqMessage;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class KmqV2 {

    public KmqV2(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    private String topic;

    private int capacity;

    private ArrayBlockingQueue<KmqMessage> queue;

    public boolean send(KmqMessage message) {
        return queue.offer(message);
    }

    public KmqMessage poll() {
        return queue.poll();
    }

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

    public KmqMessage offsetPoll(int offset) {
        return (KmqMessage) queue.toArray()[offset];
    }

    public int getQueueSize() {
        return queue.size();
    }


}
