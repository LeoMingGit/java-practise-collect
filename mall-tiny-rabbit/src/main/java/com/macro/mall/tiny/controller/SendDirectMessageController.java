package com.macro.mall.tiny.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.macro.mall.tiny.config.DirectRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendDirectMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @ResponseBody
    @GetMapping("/sendDirectMessage")
    public Object sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = StrUtil.format("hello 我叫：{} 我住在：{}",111,222);
        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime", DateUtil.now());
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(DirectRabbitConfig.TestDirectExchange, DirectRabbitConfig.TestDirectRouting, map);
        return map;
    }

    @ResponseBody
    @GetMapping("/publishMessage")
    public Object publishMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = StrUtil.format("hello 我叫：{} 我住在：{}",111,222);
        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime", DateUtil.now());
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(DirectRabbitConfig.TestDirectExchange, DirectRabbitConfig.TestDirectRouting, map);
        return map;
    }


}