package com.macro.mall.tiny.controller;


import com.macro.mall.tiny.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SendTopicMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法


    @ResponseBody
    @GetMapping("/sendTopicMessage1")
    public Object sendTopicMessage1() {
        String messageData = "message: M A N ";
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageData", messageData);
        rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange, "topic.man", manMap);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/sendTopicMessage2")
    public Object sendTopicMessage2() {
        String messageData = "message: woman is all ";
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageData", messageData);
        rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange, "topic.woman", womanMap);
        return "ok";
    }

    @ResponseBody
    @GetMapping("/sendTopicMessage3")
    public Object sendTopicMessage3() {
        String messageData = "message: xxx ";
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageData", messageData);
        //routingKey 设置'abc'；xxx队列 routingKey配置了# 看能否收到消息
        rabbitTemplate.convertAndSend(TopicRabbitConfig.topicExchange, "abc", womanMap);
        return "ok";
    }

}