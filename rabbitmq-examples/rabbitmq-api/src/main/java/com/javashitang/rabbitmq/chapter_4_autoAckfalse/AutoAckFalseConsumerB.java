package com.javashitang.rabbitmq.chapter_4_autoAckfalse;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: lilimin
 * @Date: 2019/8/26 23:30
 */
@Slf4j
public class AutoAckFalseConsumerB {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建一个ConnectionFactory，并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("117.72.43.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        // 不设置的话，默认也为/
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(AutoAckFalseProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = "errorQueue";
        channel.queueDeclare(queueName, false, false, false, null);

        String bindingKey = "error";
        channel.queueBind(queueName, AutoAckFalseProducer.EXCHANGE_NAME, bindingKey);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    // 当我们正常消息，手动ack后，消息就会从mq中删除
                    // multiple为false表示一条一条确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (Exception e) {
                    // 发生异常，发送nack，根据requeue参数来决定是将消息丢弃开始还是再重新放回队列
                    channel.basicNack(envelope.getDeliveryTag(), false, false);
                }
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };

        channel.basicConsume(queueName, false, consumer);

    }
}
