package com.macro.mall.tiny.simple;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;

public class MessageConsumer {


    @Test
    public  void  Test01() throws Exception{
        //1 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.112.137");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("test");
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        //2 创建Connection
        Connection connection = connectionFactory.newConnection();
        //3 创建Channel
        Channel channel = connection.createChannel();
        //4 创建消费者
        channel.basicConsume("myqueue", true, new DeliverCallback() {
            public void handle(String s, Delivery delivery) throws IOException {
                System.out.println("收到消息是:\t" + new String(delivery.getBody(), "UTF-8"));
            }
        }, new CancelCallback() {
            public void handle(String s) throws IOException {
                System.out.println("接收失败");
            }
        });


    }

}
