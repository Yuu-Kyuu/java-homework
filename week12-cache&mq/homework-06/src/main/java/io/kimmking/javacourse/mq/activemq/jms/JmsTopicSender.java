package io.kimmking.javacourse.mq.activemq.jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsTopicSender {

    public void testTopicProducer() throws JMSException {

        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("homework-topic");
        MessageProducer produce = session.createProducer(topic);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage("hello topic" + i);
            //发送消息
            produce.send(textMessage);
        }

        //关闭资源
        produce.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) throws JMSException {
        JmsTopicSender sender = new JmsTopicSender();
        sender.testTopicProducer();
    }
}

