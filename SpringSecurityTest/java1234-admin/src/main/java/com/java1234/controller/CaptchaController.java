package com.java1234.controller;


import com.google.code.kaptcha.Producer;
import com.java1234.common.constant.Constant;
import com.java1234.entity.R;
import com.java1234.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 验证码Controller控制器
 * @author java1234_小锋 （公众号：java1234）
 * @site www.java1234.vip
 * @company 南通小锋网络科技有限公司
 */
@RestController
public class CaptchaController {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/captcha")
    public R captcha() throws IOException {
        String key= UUID.randomUUID().toString(); // 生成随机唯一key
        String code = producer.createText();

        System.out.println("code="+code);

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        BASE64Encoder encoder = new BASE64Encoder();
        String str = "data:image/jpeg;base64,";

        String base64Img = str + encoder.encode(outputStream.toByteArray());

        redisUtil.hset(Constant.CAPTCHA_KEY,key,code,60*5);

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("base64Img",base64Img);
        resultMap.put("uuid",key);
        return R.ok(resultMap);

    }

}
