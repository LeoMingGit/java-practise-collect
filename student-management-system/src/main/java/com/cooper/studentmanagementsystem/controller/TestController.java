package com.cooper.studentmanagementsystem.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ApiOperation("SayHello")
    @RequestMapping(value = "/SayHello", method = RequestMethod.GET)
    @ResponseBody
    public String SayHello() {

        return "hello world!!!1 23";
    }

}
