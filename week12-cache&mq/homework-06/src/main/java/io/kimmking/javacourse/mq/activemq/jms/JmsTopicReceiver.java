package io.kimmking.javacourse.mq.activemq.jms;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsTopicReceiver {
    public void testTopicCustomer() throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("homework-topic");
        MessageConsumer topConsumer = session.createConsumer(topic);

        topConsumer.setMessageListener((message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }));
        System.in.read();
        System.out.println("接收完毕====");
        //关闭资源
        topConsumer.close();
        session.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        JmsTopicReceiver topicCustomer = new JmsTopicReceiver();
        topicCustomer.testTopicCustomer();
    }
}

