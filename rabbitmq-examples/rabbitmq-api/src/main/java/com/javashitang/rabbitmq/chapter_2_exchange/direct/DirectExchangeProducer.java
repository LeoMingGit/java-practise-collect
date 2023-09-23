package com.javashitang.rabbitmq.chapter_2_exchange.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DirectExchangeProducer {

    public static final String EXCHANGE_NAME = "direct_exchange";

    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("117.72.43.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        // 不设置的话，默认也为/
        connectionFactory.setVirtualHost("/");


        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(DirectExchangeProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String[] logLevel = {"info", "warning", "error"};
        for (int i = 0; i < 3; i++) {
            String routingKey = logLevel[i % 3];
            String message = "hello rabbitmq " + i;
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            log.info("send message, routingKey: {}, message: {}", routingKey, message);
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();

        for (String str : logLevel) {
            System.out.printf("[%s] %s%n", dateFormat.format(currentTime), str);
        }

        channel.close();
        connection.close();
    }
}
