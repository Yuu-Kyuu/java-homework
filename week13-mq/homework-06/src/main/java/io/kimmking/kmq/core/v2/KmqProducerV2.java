package io.kimmking.kmq.core.v2;

import io.kimmking.kmq.core.KmqMessage;

public class KmqProducerV2 {

    private KmqBrokerV2 broker;

    public KmqProducerV2(KmqBrokerV2 broker) {
        this.broker = broker;
    }

    public boolean send(String topic, KmqMessage message) {
        KmqV2 kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
        return kmq.send(message);
    }
}
