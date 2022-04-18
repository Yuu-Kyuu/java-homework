package io.kimmking.kmq.demo.homework;

import io.kimmking.kmq.core.KmqBroker;
import io.kimmking.kmq.core.KmqConsumer;
import io.kimmking.kmq.core.KmqMessage;
import io.kimmking.kmq.core.KmqProducer;
import io.kimmking.kmq.core.v2.KmqBrokerV2;
import io.kimmking.kmq.core.v2.KmqConsumerV2;
import io.kimmking.kmq.core.v2.KmqProducerV2;
import io.kimmking.kmq.demo.Order;
import lombok.SneakyThrows;

public class KmqV2Demo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "java.homework";
        KmqBrokerV2 broker = new KmqBrokerV2();
        broker.createTopic(topic);

        KmqConsumerV2 consumer = broker.createConsumer();
        consumer.subscribe(topic);
        final boolean[] flag = new boolean[1];
        flag[0] = true;
        new Thread(() -> {
            while (flag[0]) {
                KmqMessage<Order> message = consumer.offsetPoll();
                if (null != message) {
                    System.out.println(message.getBody());
                }
            }
            KmqMessage<Order> message = consumer.seek(2);
            System.out.println(message.getBody());
            System.out.println("程序退出。");
        }).start();

        KmqProducerV2 producer = broker.createProducer();
        for (int i = 0; i < 10; i++) {
            Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
            producer.send(topic, new KmqMessage(null, order));
        }
        Thread.sleep(500);
        System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");
        while (true) {
            char c = (char) System.in.read();
            if (c > 20) {
                System.out.println(c);
                producer.send(topic, new KmqMessage(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
            }

            if (c == 'q' || c == 'e') break;
        }

        flag[0] = false;

    }
}

