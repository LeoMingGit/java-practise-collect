package com.javashitang.rabbitmq.chapter_3_getMsg;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: lilimin
 * @Date: 2019/8/26 23:30
 */
@Slf4j
public class GetMsgConsumer {

    public static void main(String[] args)
        throws IOException, TimeoutException, InterruptedException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("117.72.43.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        // 不设置的话，默认也为/
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();
        channel.exchangeDeclare(GetMsgProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, GetMsgProducer.EXCHANGE_NAME, "error");

        while(true) {
            GetResponse getResponse = channel.basicGet(queueName, true);
            if (null != getResponse) {
                log.info("get message, routingKey: {}, message: {}", getResponse.getEnvelope().getRoutingKey(), new String(getResponse.getBody()));
            }
            Thread.sleep(1000);
        }
    }
}
