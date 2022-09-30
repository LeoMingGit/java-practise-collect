package com.fs.springbootds.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DsController {
    @ApiOperation("SayHello")
    @RequestMapping(value = "/SayHello", method = RequestMethod.GET)
    @ResponseBody
    public String SayHello() {

        return "hello world!!!";
    }

    @ApiOperation("StreamApi")
    @RequestMapping(value = "/StreamApi", method = RequestMethod.GET)
    @ResponseBody
    public String StreamApi() {

        //https://blog.csdn.net/qq_27005889/article/details/121053641?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-121053641-blog-124370414.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-121053641-blog-124370414.pc_relevant_default&utm_relevant_index=3
        // 流的方式操作数组
        List<String> strings = Arrays.asList("lily","bob","tom","cat","mom");

        List<String> res = strings.stream()
                .map(e->e.substring(0,1))
                .filter(e->e.charAt(0) >= 'c')
                .sorted()
                .limit(2)
                .collect(Collectors.toList());

        res.forEach(s -> {System.out.println("截取第一位字母且大于c的有： " + s);});

        return "StreamApi!!!";
    }
}
