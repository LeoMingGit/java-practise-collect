package com.javashitang.rabbitmq.chapter_1_quickstart;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 需要说明的几点如下：
 * 1.我在consumer和producer都创建了同一个exchange（exchange已经有的话不会重复创建，queue也是）
 * 是为了防止程序启动报错，因为使用一个没有创建的exchange会报错
 * 2.跑后续的demo的时候，一定要先启动consumer，后启动producer，因为我只在consumer中声明了exchange和queue的绑定关系
 * 如果先启动producer，因为exchange找不到相应的queue，所以消息会丢失
 */
@Slf4j
public class QuickStartConsumer {

    public static void main(String[] args) throws Exception {

        // 1.创建一个ConnectionFactory，并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("117.72.43.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("lix");
        connectionFactory.setPassword("123456");
        // 不设置的话，默认也为/
        connectionFactory.setVirtualHost("/");

        // 2.通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        // 3.通过connection创建一个channel
        Channel channel = connection.createChannel();

        String queueName = "quickStartErrorQueue";
        /**
         * 因为direct类型的Exchange路由会把消息路由到那些binding key与routing key完全匹配的queue中，
         * 所以direct中路由键和绑定键是相等的。【默认交换机隐式绑定到每个队列，路由关键字等于队列名称】
         * links:
         * https://juejin.cn/post/7237001554083971129
         */
        String bindingKey = "error";
        // 4.创建交换器
        // 因为不知道生产者和消费者程序哪个先启动，所以一般的做法是在生产者和消费者2边都创建交换器（有的话不会重复创建）
        channel.exchangeDeclare(QuickStartProducer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        /**
         * 5.声明（创建）一个队列
         * queue: 队列名字
         * durable: 是否持久化
         * exclusive: 是否独占
         * autoDelete: 队列脱离exchange，自动删除
         * arguments: 扩展参数
         */
        channel.queueDeclare(queueName, true, false, false ,null);
        // 6.绑定交换机和队列
        channel.queueBind(queueName, QuickStartProducer.EXCHANGE_NAME, bindingKey);

        // 7.创建消费者
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                log.info("get message, routingKey: {}, message: {}", envelope.getRoutingKey() ,message);
            }
        };

        // 8.消费者开始消费数据
        channel.basicConsume(queueName , true, consumer);

    }
}
