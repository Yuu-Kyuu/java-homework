package io.kimmking.javacourse.mq.activemq.jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsQueueSender {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("homework-queue");
            MessageProducer producer = session.createProducer(destination);
            for (int i = 0; i < 10; i++) {
                TextMessage textMessage = session.createTextMessage("hello,queue"+i);
                producer.send(textMessage);
            }
            session.commit();
            session.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
