package io.kimmking.javacourse.mq.activemq.jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsQueueReceiver {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("homework-queue");
            MessageConsumer consumer = session.createConsumer(destination);
            for (int i = 1; i <= 10; i++) {
                System.out.println(((TextMessage) consumer.receive()).getText());
            }
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}