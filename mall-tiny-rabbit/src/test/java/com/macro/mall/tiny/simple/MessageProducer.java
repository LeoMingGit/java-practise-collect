package com.macro.mall.tiny.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

public class MessageProducer  {

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
        //4. 声明队列
        channel.queueDeclare("myqueue",true,false,false,null);

        //5 发送消息

        String msg = "Test Message";
        //exchange 为空 默认走RabbitMQ默认交换机
        channel.basicPublish("","myqueue",null, msg.getBytes());

        channel.close();
        connection.close();


    }

}
