package com.javashitang.rabbitmq.chapter_3_getMsg;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: lilimin
 * @Date: 2019/8/26 23:32
 */
@Slf4j
public class GetMsgProducer {

    public static final String EXCHANGE_NAME = "getMessage_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("117.72.43.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        // 不设置的话，默认也为/
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String routingKey = "error";
        for (int i = 0; i < 3; i++) {
            String message = "hello rabbitmq" + (i + 1);
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            log.info("send message, routingKey: {}, message: {}", routingKey, message);
        }
        channel.close();
        connection.close();
    }
}
