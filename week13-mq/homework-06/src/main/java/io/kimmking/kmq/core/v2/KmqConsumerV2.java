package io.kimmking.kmq.core.v2;

import io.kimmking.kmq.core.KmqMessage;


public class KmqConsumerV2<T> {
    private final KmqBrokerV2 broker;
    private KmqV2 kmq;

    private int offset = 0;

    public KmqConsumerV2(KmqBrokerV2 broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public KmqMessage<T> poll(long timeout) {
        return kmq.poll(timeout);
    }

    public KmqMessage<T> offsetPoll() {
        if (offset < kmq.getQueueSize()) {
            return kmq.offsetPoll(offset++);
        } else {
            return null;
        }
    }

    public KmqMessage<T> seek(int target) {
        return kmq.offsetPoll(target);
    }
}
