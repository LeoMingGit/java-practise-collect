package com.example.quartzhello.controller;

import com.example.quartzhello.service.impl.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("sayHello")
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String  sayHello() {
        String str=testService.sayHello();
        System.out.println(str);
        return str;
    }
}
