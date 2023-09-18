package com.macro.mall.tiny.controller;


import cn.hutool.core.date.DateUtil;
import com.macro.mall.tiny.config.FanoutRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 扇型交换机，这个交换机没有路由键概念，就算你绑了路由键也是无视的。
 * 这个交换机在接收到消息后，会直接转发到绑定到它上面的所有队列。
 */
@RestController
public class SendFanoutMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {

        //region

        String messageData = "FanoutMessage routingKey is null";
        Map<String, Object> map = new HashMap<>();
        map.put("createTime", DateUtil.now());
        map.put("messageData", messageData);
        rabbitTemplate.convertAndSend(FanoutRabbitConfig.fanoutExchange,null, map);
        return "ok";

        //endregion
    }
    @GetMapping("/sendFanoutMessage1")
    public String sendFanoutMessage1() {
        String messageData = "FanoutMessage routingKey is 'xxx'";
        Map<String, Object> map = new HashMap<>();
        map.put("createTime", DateUtil.now());
        map.put("messageData", messageData);
        //扇型交换机，这个交换机没有路由键概念，就算你绑了路由键也是无视的。 这个接口绑定一下路由键
        rabbitTemplate.convertAndSend(FanoutRabbitConfig.fanoutExchange,"xxx", map);
        return "ok";
    }
}