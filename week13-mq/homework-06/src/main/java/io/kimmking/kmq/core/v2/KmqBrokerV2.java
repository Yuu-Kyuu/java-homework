package io.kimmking.kmq.core.v2;

import io.kimmking.kmq.core.Kmq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class KmqBrokerV2 { // Broker+Connection

    public static final int CAPACITY = 10000;

    private final Map<String, KmqV2> kmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name) {
        kmqMap.putIfAbsent(name, new KmqV2(name, CAPACITY));
    }

    public KmqV2 findKmq(String topic) {
        return this.kmqMap.get(topic);
    }

    public KmqProducerV2 createProducer() {
        return new KmqProducerV2(this);
    }

    public KmqConsumerV2 createConsumer() {
        return new KmqConsumerV2(this);
    }

}
