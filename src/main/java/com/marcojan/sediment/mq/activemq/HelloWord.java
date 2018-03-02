package com.marcojan.sediment.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Marco on 12/02/2018.
 */
public class HelloWord {

    public static void main(String[] args) throws Exception{

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD,"tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("queue1");

        MessageProducer messageProducer = session.createProducer(destination);

        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        TextMessage textMessage = session.createTextMessage("test activemq");

        messageProducer.send(textMessage);
    }
}
